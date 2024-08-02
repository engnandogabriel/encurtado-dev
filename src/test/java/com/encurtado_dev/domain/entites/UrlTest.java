package com.encurtado_dev.domain.entites;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UrlTest {
    @Test
    @DisplayName("Should be created a new Url")
    void testCreate() throws Exception {
        String longUrl = "http://www.example.com";
        String shortenedUrl = "http://shortenedUrl/abc";
        String hash = "someHash";
        String qrCode = "someQrCode";
        Url url = Url.create(longUrl,shortenedUrl, hash, qrCode);
        Assertions.assertNotNull(url.getUrlId());
        Assertions.assertEquals(longUrl, url.getLongUrl());
        Assertions.assertEquals(hash, url.getHash());
        Assertions.assertEquals(qrCode, url.getQrCode());
        Assertions.assertNotNull(url.getCreatedAt());
    }

    @Test
    @DisplayName("Should be restored a Url")
    void testRestore() {
        String urlId = UUID.randomUUID().toString();
        String longUrl = "http://www.example.com";
        String shortenedUrl = "http://shortenedUrl/abc";
        String hash = "someHash";
        String qrCode = "someQrCode";
        LocalDateTime createdAt = LocalDateTime.now();
        Url url = Url.restore(urlId, longUrl, shortenedUrl, hash, qrCode, createdAt);
        Assertions.assertEquals(urlId, url.getUrlId());
        Assertions.assertEquals(longUrl, url.getLongUrl());
        Assertions.assertEquals(hash, url.getHash());
        Assertions.assertEquals(qrCode, url.getQrCode());
        Assertions.assertEquals(createdAt, url.getCreatedAt());
    }
}