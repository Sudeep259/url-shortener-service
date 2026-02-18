package com.sudeep.url_shortner.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "urls")
public class UrlMapping {

    @Id
    private String id;

    private String shortCode;
    private String originalUrl;
    private long createdAt;
    private long clickCount;
}
