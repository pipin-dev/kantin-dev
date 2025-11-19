Kantin REST API

Simple Spring Boot REST API to manage canteen product CRUD operations.

Tech stack

Java 17

Spring Boot 3.2.x

Spring Data JPA (Hibernate)

PostgreSQL (local or Docker)

Lombok

OpenAPI / Swagger (springdoc-openapi)

Setup (Quick Guide)
Option A — Run with local PostgreSQL

Create database:

CREATE DATABASE kantin_db;

CREATE USER kantin_user WITH ENCRYPTED PASSWORD 'kantin123';

GRANT ALL PRIVILEGES ON DATABASE kantin_db TO kantin_user;


Make sure PostgreSQL is running and accessible at localhost:5432.

Update application.properties if needed:

File: src/main/resources/application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/kantin_db
spring.datasource.username=kantin_user
spring.datasource.password=kantin123

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true


Run the application:

mvn spring-boot:run


Open Swagger UI:

http://localhost:8080/swagger-ui/index.html

Option B — Run with Docker Compose

Start PostgreSQL:

docker-compose up -d


Database details:

Database: kantin_db

User: kantin_user

Password: kantin123

Port: 5432

Spring Boot will automatically connect using application.properties.

API Endpoints
Method	Endpoint	Description
GET	/api/products	Get all products
GET	/api/products/{id}	Get product by ID
POST	/api/products	Create new product
PUT	/api/products/{id}	Update product
DELETE	/api/products/{id}	Delete product
Example JSON (POST)
{
  "name": "Nasi Goreng",
  "description": "Pedas",
  "price": 15000,
  "active": true
}

Project Structure
src/main/java/com/example/kantin/
 ├── controller/
 ├── service/
 ├── repository/
 ├── model/
 └── dto/

src/main/resources/
 └── application.properties

sql/
 └── create_kantin_db.sql
