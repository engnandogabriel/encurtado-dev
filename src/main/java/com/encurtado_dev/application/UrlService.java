package com.encurtado_dev.application;

import com.encurtado_dev.domain.DTO.ShortenUrlDTO;
import com.encurtado_dev.domain.entites.Url;
import com.encurtado_dev.domain.repository.UrlRepository;
import com.encurtado_dev.domain.value_objects.HashCode;
import com.encurtado_dev.domain.value_objects.QrCode;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    private UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public void shorten(ShortenUrlDTO shortenUrlDTO,  String localUrl){
        try {
            HashCode hash;
            do {
                hash = new HashCode();
            } while (this.urlRepository.existByHash(hash.getHashCode()));
            QrCode qrCode = new QrCode(localUrl+hash.getHashCode());
            Url url = Url.create(shortenUrlDTO.longUrl(), hash.getHashCode(), qrCode.getQrCode());
            this.urlRepository.save(url);
        } catch (Exception e){}

    }
    public String getLink(String hash){
        try {
            Url url = this.urlRepository.findByHash(hash).orElse(null);
            if(url == null) return "";
            return url.getLongUrl();
        } catch (Exception e){
            return "";
        }
    }
}
