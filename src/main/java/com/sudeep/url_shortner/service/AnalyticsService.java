package com.sudeep.url_shortner.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AnalyticsService {

    /**
     * Async click tracking
     * Simulates sending event to AWS Lambda / Queue
     */
    @Async
    public void trackClick(String shortCode) {

        // In real production:
        // Send event to Kafka / SQS / Lambda

        log.info("Tracking click for short URL: {}", shortCode);

        // simulate processing delay
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
