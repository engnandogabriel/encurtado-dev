package com.encurtado_dev.infra.Models;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MongoDB extends MongoRepository<UrlModel, String> {
    Optional<UrlModel> findByHash(String hash);
    boolean existsByHash(String hash);
}
