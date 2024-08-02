package com.encurtado_dev.domain.repository;

import com.encurtado_dev.domain.entites.Url;

import java.util.Optional;

public interface UrlRepository {
    void save(Url url);
    Optional<Url> findById(String id);
    Optional<Url> findByHash(String hash);
    boolean existByHash(String hash);

}
