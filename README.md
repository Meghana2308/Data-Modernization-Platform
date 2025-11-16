# Data-Modernization-Platform

## Overview
A sample Spring Boot application for practicing data modernization tasks (Postgres + simulated legacy). 
Module 1 provides base CRUD, Docker Compose, and health checks.

## Run Locally
1. Build:
   ```bash
   mvn clean package -DskipTests

2. Start services with Docker Compose:
   ```bash
   docker-compose up --build

3. Verify the application
   ```bash
   http://localhost:8080/actuator/health
   
4. Sample API endpoint
     ```bash
   POST /api/customers

5. Stop Services
    ```bash
   docker-compose down
   
#### 
Note: If your docker-compose.yml is in the docker/ folder, you can run:
```bash
  docker-compose -f docker/docker-compose.yml up --build
