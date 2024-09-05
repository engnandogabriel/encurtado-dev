package com.encurtado_dev.controller;

import com.encurtado_dev.application.UrlService;
import com.encurtado_dev.domain.DTO.ShortenUrlDTO;
import com.encurtado_dev.domain.HandlersService.HandlerDTO;
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
    public ResponseEntity<HandlerDTO> shorten(@RequestBody ShortenUrlDTO shortenUrlDTO, HttpServletRequest servletRequest){
        var localUrl = servletRequest.getRequestURL().toString().replace("shorten", "");
        HandlerDTO output = this.urlService.shorten(shortenUrlDTO, localUrl);
        return ResponseEntity.status(output.status().value()).body(output);
    }
    @GetMapping("/{hash}")
    public ResponseEntity<HandlerDTO> getLink(@PathVariable(name = "hash") String hash){
        HandlerDTO output = this.urlService.getLink(hash);
        HttpHeaders headers = new HttpHeaders();
        if(output.status().value() != 200){
            return ResponseEntity.status(output.status()).body(output);
        }
        headers.setLocation(URI.create(output.body().toString()));
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }
    @GetMapping("/{hash}/data")
    public ResponseEntity<HandlerDTO> getData(@PathVariable(name="hash") String hash){
        HandlerDTO output = this.urlService.getDatas(hash);
        return ResponseEntity.status(output.status().value()).body(output);
    }
}
