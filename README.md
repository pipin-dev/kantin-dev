Kantin Spring Boot — REST API CRUD

Template proyek Java Spring Boot sederhana untuk REST API CRUD data produk kantin.
Menggunakan Spring Boot, Spring Data JPA, dan PostgreSQL.
Termasuk instruksi lengkap pembuatan database (manual & Docker), struktur project, dan cara menjalankan aplikasi.

✨ Fitur

CRUD Produk (nama, deskripsi, harga, status)

Struktur project rapi (Controller → Service → Repository → DTO)

PostgreSQL (manual atau Docker)

SQL skrip pembuatan database

Hibernate auto-update schema

Siap deploy & dikembangkan

📁 Struktur Project (Ringkas)
kantin-springboot/
 ├── README.md
 ├── pom.xml
 ├── docker-compose.yml
 ├── sql/
 │    └── create_kantin_db.sql
 ├── src/main/java/com/example/kantin/
 │    ├── controller/
 │    ├── dto/
 │    ├── exception/
 │    ├── model/
 │    ├── repository/
 │    └── service/
 └── src/main/resources/
      └── application.properties

📌 Prasyarat

Java 17

Maven 3.8+

PostgreSQL 12+ atau Docker

IDE (IntelliJ / VSCode / Eclipse)

🛢️ Cara Membuat Database PostgreSQL
1️⃣ Cara Manual (Tanpa Docker)

Login ke PostgreSQL:

psql -U postgres


Lalu jalankan:

CREATE DATABASE kantin_db;
CREATE USER kantin_user WITH ENCRYPTED PASSWORD 'kantin123';
GRANT ALL PRIVILEGES ON DATABASE kantin_db TO kantin_user;

2️⃣ Cara Otomatis Menggunakan Docker Compose

Jalankan:

docker-compose up -d


Akan membuat:

Database: kantin_db

Username: kantin_user

Password: kantin123

Port: 5432

⚙️ Konfigurasi application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/kantin_db
spring.datasource.username=kantin_user
spring.datasource.password=kantin123
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

▶️ Cara Menjalankan Project
1. Build
mvn clean install

2. Jalankan
mvn spring-boot:run


Aplikasi berjalan di:

http://localhost:8080

📚 Endpoint API
GET Semua Produk
GET /api/products

GET Produk berdasarkan ID
GET /api/products/{id}

POST Tambah Produk
POST /api/products
Content-Type: application/json


Example body:

{
  "name": "Nasi Goreng",
  "description": "Pedas",
  "price": 15000,
  "active": true
}

PUT Update Produk
PUT /api/products/{id}

DELETE Produk
DELETE /api/products/{id}

📝 SQL File Lokasi
/sql/create_kantin_db.sql


Isi file:

CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price NUMERIC(12,2) NOT NULL,
    active BOOLEAN DEFAULT TRUE
);
