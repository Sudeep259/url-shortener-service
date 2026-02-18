![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-green)
![MongoDB](https://img.shields.io/badge/MongoDB-Database-darkgreen)
![Redis](https://img.shields.io/badge/Redis-Cache-red)
![License](https://img.shields.io/badge/License-MIT-blue)

# 🔗 Scalable URL Shortener Service

> High-performance URL shortening service demonstrating caching, distributed design, and scalable backend architecture.

A production-style URL shortening service built using **Java, Spring Boot, MongoDB, Redis, and Docker**, designed for high performance and scalability.

---

## 🚀 Features

- Generate short URLs using Base62 encoding
- O(1) URL lookup performance
- Redis caching layer for ultra-fast redirects
- MongoDB persistent storage
- Async analytics tracking
- RESTful API architecture
- Docker-based local setup

---

## 🏗️ Architecture
```
Client
↓
Spring Boot API
↓
Redis Cache (L1)
↓
MongoDB Database
↓
Async Analytics Service
```

---

## 🧰 Tech Stack

- Java 17+
- Spring Boot
- MongoDB
- Redis
- Maven
- Docker

---

## ⚡ API Endpoints

### Create Short URL

POST /shorten

**Request**

```json
{
  "url": "https://google.com"
}
```
Response
```
aB12Xy
```
Redirect
```
GET /{shortCode}
```
▶️ Run Locally
1. Start Databases
   ```
   docker run -d -p 27017:27017 mongo
   docker run -d -p 6379:6379 redis
   ```
2. Run Application
   ```
   mvn spring-boot:run
   ```
Server runs at:
```
http://localhost:8080
```
📈 Performance Design

Redis reduces database load

Indexed MongoDB lookup

Async click tracking

Horizontally scalable architecture

👨‍💻 Author

Sudeep Kumar S M

GitHub: https://github.com/Sudeep259
