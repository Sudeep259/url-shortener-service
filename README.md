# Scalable URL Shortener Service

## Tech Stack
- Java
- Spring Boot
- MongoDB
- Redis
- Docker

## Features
- O(1) URL lookup
- Redis caching layer
- Async analytics tracking
- RESTful API design
- Horizontal scalability ready

## Architecture
Client → Spring Boot → Redis → MongoDB

## Run Locally
1. Start MongoDB & Redis using Docker
2. mvn spring-boot:run
