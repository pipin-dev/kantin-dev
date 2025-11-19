# Project Title

Short description of what this project does and who it is for.

---

## Tech Stack

- Java 17
- Spring Boot (3.x)
- Spring Data JPA (Hibernate)
- PostgreSQL
- Lombok
- OpenAPI / Swagger (springdoc)

---

## Setup (Quick Start)

### Option A — Run with Local PostgreSQL

1. Create database:
```sql
CREATE DATABASE hospitaldb;
-- Make sure PostgreSQL is running and accessible at localhost:5432
```
2. Update `src/main/resources/application.properties` if needed (currently uses `postgre` / `admin`).
3. Run:
```bash
mvn spring-boot:run
```
Open Swagger UI: `http://localhost:8080/swagger-ui/index.html`

### Option B — run with Docker Compose (recommended)
If you have Docker, a `docker-compose.yml` is included. Run:
```bash
docker compose up -d
# wait a few seconds for Postgres to be ready
mvn spring-boot:run
```
## Endpoints (summary)
| Method | Endpoint            | Description     |
| ------ | ------------------- | --------------- |
| GET    | /api/resources      | Get all items   |
| GET    | /api/resources/{id} | Get item by ID  |
| POST   | /api/resources      | Create new item |
| PUT    | /api/resources/{id} | Update item     |
| DELETE | /api/resources/{id} | Delete item     |
