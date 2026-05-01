# Distributed Inventory Management System

A production-ready microservices platform built with Java 17 and Spring Boot.

## Architecture
- **API Gateway**: Entry point (Port 8080).
- **Auth Service**: Security and User Management.
- **Inventory Service**: CRUD for products and stock.
- **Notification Service**: Low-stock alerts history.

## How to Run
1. Ensure Docker Desktop is running.
2. In the root directory, run:
   ```bash
   mvn clean package -DskipTests
   docker compose up --build