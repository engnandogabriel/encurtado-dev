package com.encurtado_dev.controller;

import com.encurtado_dev.application.UrlService;
import com.encurtado_dev.domain.DTO.ShortenUrlDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

@RestController
@RequestMapping(value = "/")
public class UrlController {
    UrlService urlService;
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<String> shorten(@RequestBody ShortenUrlDTO shortenUrlDTO, HttpServletRequest servletRequest){
        var localUrl = servletRequest.getRequestURL().toString().replace("shorten", "");
        this.urlService.shorten(shortenUrlDTO, localUrl);
        return ResponseEntity.ok("Created");
    }
    @GetMapping("/{hash}")
    public ResponseEntity<String> getLink(@PathVariable(name = "hash") String hash){

        String url = this.urlService.getLink(hash);
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url));
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }
}
