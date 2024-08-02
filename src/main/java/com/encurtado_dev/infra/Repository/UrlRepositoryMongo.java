package com.encurtado_dev.infra.Repository;

import com.encurtado_dev.domain.repository.UrlRepository;
import com.encurtado_dev.domain.entites.Url;
import com.encurtado_dev.infra.Models.MongoDB;
import com.encurtado_dev.infra.Models.UrlModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UrlRepositoryMongo implements UrlRepository {

    private MongoDB mongoDB;
    public UrlRepositoryMongo(MongoDB mongoDB) {
        this.mongoDB = mongoDB;
    }

    @Override
    public void save(Url url) {
        UrlModel urlModel = new UrlModel(url.getUrlId(), url.getLongUrl(), url.getShortenedUrl(), url.getHash(), url.getQrCode(), url.getCreatedAt());
        this.mongoDB.save(urlModel);
    }

    @Override
    public Optional<Url> findById(String id) {
        UrlModel urlModel = this.mongoDB.findById(id).orElse(null);
        if(urlModel == null) return Optional.empty();
        return Optional.of(Url.restore(urlModel.getUrlId(), urlModel.getLongUrl(), urlModel.getShortenedUrl() ,urlModel.getHash(), urlModel.getQrCode(), urlModel.getCreatedAt()));
    }

    @Override
    public Optional<Url> findByHash(String hash) {
        UrlModel urlModel = this.mongoDB.findByHash(hash).orElse(null);
        if(urlModel == null) return Optional.empty();
        return Optional.of(Url.restore(urlModel.getUrlId(), urlModel.getLongUrl(), urlModel.getShortenedUrl(), urlModel.getHash(), urlModel.getQrCode(), urlModel.getCreatedAt()));
    }

    @Override
    public boolean existByHash(String hash) {
        Boolean exits = this.mongoDB.existsByHash(hash);
        return exits;
    }
}
