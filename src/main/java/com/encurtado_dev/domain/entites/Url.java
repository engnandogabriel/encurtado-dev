package com.encurtado_dev.domain.entites;

import com.encurtado_dev.domain.value_objects.LongURL;

import java.time.LocalDateTime;
import java.util.UUID;

public class Url {
    private String urlId;
    private String longUrl;
    private String hash;
    private String qrCode;
    private LocalDateTime createdAt;

    public Url(String urlId, String longUrl, String hash, String qrCode, LocalDateTime createdAt) {
        this.urlId = urlId;
        this.longUrl = longUrl;
        this.hash = hash;
        this.qrCode = qrCode;
        this.createdAt = createdAt;
    }

    public static Url create(String longUrl, String hash, String qrCode) throws Exception {
        String id = UUID.randomUUID().toString();
        LocalDateTime createdAt = LocalDateTime.now();
        return new Url(id, new LongURL(longUrl).getLongUrl(), hash, qrCode, createdAt);
    }

    public static Url restore( String urlId, String longUrl, String hash, String qrCode, LocalDateTime createdAt){
        return new Url(urlId, longUrl, hash, qrCode, createdAt);
    }
    public String getUrlId() {
        return urlId;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public String getHash() {
        return hash;
    }

    public String getQrCode() {
        return qrCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
