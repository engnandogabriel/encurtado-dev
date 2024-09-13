package com.encurtado_dev.infra.Models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "urls")
public class UrlModel {
    @Id
    private String urlId;
    private String longUrl;
    private String shortenedUrl;
    private String hash;
    private String qrCode;
    private LocalDateTime createdAt;

    public UrlModel() {
    }

    public UrlModel(String urlId, String longUrl,String shortenedUrl, String hash, String qrCode, LocalDateTime createdAt) {
        this.urlId = urlId;
        this.longUrl = longUrl;
        this.shortenedUrl = shortenedUrl;
        this.hash = hash;
        this.qrCode = qrCode;
        this.createdAt = createdAt;
    }

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public void setShortenedUrl(String shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
