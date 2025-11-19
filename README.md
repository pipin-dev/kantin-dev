Kantin Spring Boot — REST API CRUD

Template proyek Java Spring Boot sederhana untuk REST API CRUD data produk kantin. Menggunakan Spring Boot, JPA, dan PostgreSQL. Termasuk instruksi lengkap pembuatan database, Docker Compose, struktur project, dan cara menjalankan aplikasi.

Fitur:

CRUD Produk (nama, deskripsi, harga, status)

Struktur project rapi (Controller → Service → Repository → DTO)

PostgreSQL (manual atau Docker)

SQL skrip pembuatan database

Hibernate auto update schema

Struktur Project

kantin-springboot/
README.md
pom.xml
docker-compose.yml
sql/create_kantin_db.sql
src/main/java/com/example/kantin/...
src/main/resources/application.properties
.gitignore

Prasyarat

Java 17

Maven 3.8+

PostgreSQL 12+ atau Docker

Git (opsional)

=========================================
A. SETUP DATABASE MENGGUNAKAN DOCKER

Isi file docker-compose.yml:

version: "3.8"
services:
db:
image: postgres:15
environment:
POSTGRES_DB: kantin
POSTGRES_USER: kantin_user
POSTGRES_PASSWORD: your_password_here
ports:
- "5432:5432"
volumes:
- kantin-db-data:/var/lib/postgresql/data

volumes:
kantin-db-data:

Jalankan:

docker compose up -d

Database siap dengan:
Host: localhost
Port: 5432
User: kantin_user
Password: your_password_here
DB: kantin

=========================================
B. SETUP DATABASE MANUAL TANPA DOCKER

Gunakan SQL berikut:

CREATE USER kantin_user WITH PASSWORD 'your_password_here';
CREATE DATABASE kantin OWNER kantin_user;
\c kantin;

CREATE TABLE product (
id BIGSERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
description TEXT,
price NUMERIC(12,2) NOT NULL DEFAULT 0,
available BOOLEAN NOT NULL DEFAULT true,
created_at TIMESTAMP WITH TIME ZONE DEFAULT now(),
updated_at TIMESTAMP WITH TIME ZONE DEFAULT now()
);

INSERT INTO product (name, description, price, available) VALUES
('Nasi Goreng', 'Nasi goreng special', 15000.00, true),
('Teh Manis', 'Teh manis hangat', 5000.00, true);

=========================================
KONFIGURASI APLIKASI (application.properties)

spring.datasource.url=jdbc:postgresql://localhost:5432/kantin
spring.datasource.username=kantin_user
spring.datasource.password=your_password_here
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
server.port=8080

Jika pakai Docker, host bisa diganti:
spring.datasource.url=jdbc:postgresql://db:5432/kantin

=========================================
MENJALANKAN APLIKASI

Build aplikasi:

mvn clean package -DskipTests

Jalankan:

java -jar target/kantin-0.0.1-SNAPSHOT.jar

Aplikasi berjalan di:
http://localhost:8080

=========================================
ENDPOINT API

GET /api/products → list produk
GET /api/products/{id} → detail produk
POST /api/products → tambah produk
PUT /api/products/{id} → update produk
DELETE /api/products/{id} → hapus produk

=========================================
CONTOH CURL

Tambah produk:

curl -X POST http://localhost:8080/api/products
 -H "Content-Type: application/json" -d "{
"id": null,
"name": "Es Jeruk",
"description": "Segar banget",
"price": 8000.00,
"available": true
}"

List produk:

curl http://localhost:8080/api/products

=========================================
PENGEMBANGAN LANJUTAN

Pagination & sorting

Validasi DTO (@Valid)

Swagger/OpenAPI

JWT Authentication

Modul transaksi

Unit test

=========================================
SELESAI
