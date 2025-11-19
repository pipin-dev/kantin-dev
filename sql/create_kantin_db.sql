-- jika ingin manual (bukan via docker env vars)
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


-- sample data
INSERT INTO product (name, description, price, available) VALUES
('Nasi Goreng', 'Nasi goreng special', 15000.00, true),
('Teh Manis', 'Teh hangat dengan gula', 5000.00, true);
