package com.encurtado_dev.domain.DTO;

public record ShortenUrlResponseDTO(String longUrl, String url, String hash, String QrCode) {
}
