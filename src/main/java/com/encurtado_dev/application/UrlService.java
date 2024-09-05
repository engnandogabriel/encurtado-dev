package com.encurtado_dev.application;

import com.encurtado_dev.domain.DTO.ShortenUrlDTO;
import com.encurtado_dev.domain.DTO.ShortenUrlResponseDTO;
import com.encurtado_dev.domain.Exception.NotFoundError;
import com.encurtado_dev.domain.HandlersService.HandlerDTO;
import com.encurtado_dev.domain.HandlersService.Handlers;
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

    public HandlerDTO shorten(ShortenUrlDTO shortenUrlDTO, String localUrl){
        try {
            HashCode hash;
            do {
                hash = new HashCode();
            } while (this.urlRepository.existByHash(hash.getHashCode()));
            String shortenedUrl = localUrl + hash.getHashCode();
            QrCode qrCode = new QrCode(shortenedUrl);
            Url url = Url.create(shortenUrlDTO.longUrl(), shortenedUrl, hash.getHashCode(), qrCode.getQrCode());
            this.urlRepository.save(url);
            ShortenUrlResponseDTO shortenUrlResponseDTO = new ShortenUrlResponseDTO(url.getLongUrl(), shortenedUrl, url.getHash(), url.getQrCode());
            return new Handlers<>().success(shortenUrlResponseDTO);
        } catch (RuntimeException e){
            return new Handlers<>().servrError(e);
        } catch (Exception e){
            return new Handlers<>().badRquest(e);
        }

    }
    public HandlerDTO getLink(String hash){
        try {
            Url url = this.urlRepository.findByHash(hash).orElse(null);
            if(url == null) return new Handlers<>().notFound(new NotFoundError("URL não encontrada"));
            return new Handlers<>().success(url.getLongUrl());
        } catch (RuntimeException e) {
            return new Handlers<>().servrError(e);
        } catch (Exception e) {
            return new Handlers<>().badRquest(e);
        }
    }
    public HandlerDTO getDatas(String hash){
        try {
           Url url = this.urlRepository.findByHash(hash).orElse(null);
            if(url == null) return new Handlers<>().notFound(new NotFoundError("URL não encontrada"));
            return  new Handlers<>().success(url);
        }catch (RuntimeException e) {
            return new Handlers<>().servrError(e);
        } catch (Exception e) {
            return new Handlers<>().badRquest(e);
        }
    }
}