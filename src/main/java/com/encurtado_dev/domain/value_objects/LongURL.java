package com.encurtado_dev.domain.value_objects;

public class LongURL {
    private static final String URL_REGEX =
            "^((https?|ftp)://)?(([a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,6})(:[0-9]{1,5})?(/.*)?$";
    private String longUrl;

    public LongURL(String longUrl) throws Exception {
        this.longUrl = this.validate(longUrl);
    }

    private String validate(String url) throws Exception {
        if (url == null || url.isEmpty()) {
            throw new Exception("Deve ser fornecida uma URL");
        }
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            throw new IllegalArgumentException("URL inválida. Deve começar com https:// ou http://");
        }
        return url;
    }

    public String getLongUrl() {
        return longUrl;
    }
}

