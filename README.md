# BookVerse

BookVerse is a microservices-based sample platform for managing books.

## Architecture
- Config Server — centralizes service configuration (Services/ConfigServer)
- Discovery Service (Eureka) — service registration and discovery (Services/DiscoveryService)
- Book Service — core domain service exposing book CRUD APIs (Services/BookService)

### Diagrams: 
- Diagrams/*.png

## Tech stack
- Java 17
- Spring Boot (Web, Data JPA)
- Flyway for DB migrations
- PostgreSQL (expected)
- Maven build System

## Getting started
Prerequisites: Java 17+, Maven, Docker

1. Start infrastructure:
   ```
   docker-compose up -d
   ```
2. Config Server:
   ```
   cd Services/ConfigServer
   ./mvnw spring-boot:run
   ```
3. Discovery Service:
   ```
   cd Services/DiscoveryService
   ./mvnw spring-boot:run
   ```
4. **Book Service**

   **Linux / macOS / WSL**
   ```bash
   cd Services/BookService

   DB_USERNAME=your_database_username \
   DB_PASSWORD=your_password \
   ./mvnw spring-boot:run
   ```

   **Windows (PowerShell)**
   ```powershell
   cd Services/BookService

   $env:DB_USERNAME="postgres"
   $env:DB_PASSWORD="your_password"

   .\mvnw.cmd spring-boot:run
   ```

Application configuration lives under Services/ConfigServer/src/main/resources/configurations/* and service application.yml files.

## Database
BookService includes Flyway migrations at:
- Services/BookService/src/main/resources/db/migration/V1__init_database.sql
- Services/BookService/src/main/resources/db/migration/V2__insert_dummy_books.sql

Ensure PostgreSQL credentials(provided a .env.example - rename it to .env and put your credentials) in application.yaml match your environment.

## API
BookService exposes REST endpoints under /api/v1/books
- GET /api/v1/books — returns list of books (BookResponseDTO)

TODO: Add POST, PUT, DELETE endpoints and admin authorization (not yet implemented).

## Project layout
- Services/ConfigServer — configuration server
- Services/DiscoveryService — service discovery
- Services/BookService — book domain service (model, repository, service, controller)

## Contributing
Contributions welcome. Open issues or pull requests with clear descriptions.

