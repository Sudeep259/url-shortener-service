package com.sudeep.url_shortner.service;

import com.sudeep.url_shortner.model.UrlMapping;
import com.sudeep.url_shortner.repository.UrlRepository;
import com.sudeep.url_shortner.util.Base62Encoder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlService {
    private final AnalyticsService analyticsService;

    private final UrlRepository repository;
    private final RedisTemplate<String,String> redisTemplate;

    public String createShortUrl(String originalUrl) {

        long id = System.currentTimeMillis();
        String code = Base62Encoder.encode(id);

        UrlMapping mapping = UrlMapping.builder()
                .shortCode(code)
                .originalUrl(originalUrl)
                .createdAt(System.currentTimeMillis())
                .clickCount(0)
                .build();

        repository.save(mapping);

        redisTemplate.opsForValue().set(code, originalUrl);

        return code;
    }

    
    public String getOriginalUrl(String code) {

    String cached = redisTemplate.opsForValue().get(code);

    if (cached != null) {
        analyticsService.trackClick(code);
        return cached;
    }

    UrlMapping mapping =
            repository.findByShortCode(code).orElseThrow();

    redisTemplate.opsForValue()
            .set(code, mapping.getOriginalUrl());

    analyticsService.trackClick(code);

    return mapping.getOriginalUrl();
}

}
