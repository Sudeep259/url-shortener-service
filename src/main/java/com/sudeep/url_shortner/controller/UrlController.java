package com.sudeep.url_shortner.controller;

import com.sudeep.url_shortner.dto.UrlRequest;
import com.sudeep.url_shortner.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService service;

    @PostMapping("/shorten")
public String shorten(@Valid @RequestBody UrlRequest request) {
    return service.createShortUrl(request.getUrl());
}


    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {

        String url = service.getOriginalUrl(code);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url))
                .build();
    }
}
