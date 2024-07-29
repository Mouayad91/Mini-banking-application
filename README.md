# Banking Application

## Overview

Mini Banking Application built using Spring Boot, Spring Security, and PostgreSQL. 
It allows users to manage their bank accounts, perform transactions, and ensures secure authentication and authorization.

## Features

- User Registration and Authentication
- Account Management (Create, View, Update, Delete)
- Fund Transfer between Accounts
- Logging and Performance Monitoring with AOP
- Input Validation and Error Handling
- Role-based Authorization

## Technologies Used

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- PostgreSQL
- Hibernate (JPA)
- Lombok
- AspectJ (AOP)

## Prerequisites

- Java 17 or later
- Maven
- PostgreSQL

## Getting Started

### Database Setup

1. Install PostgreSQL and create a database named `banking_app`.

    ```sql
    CREATE DATABASE banking_app;
    ```

2. Update the `application.properties` file with your PostgreSQL credentials.

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/banking_app
    spring.datasource.username=your_postgres_username
    spring.datasource.password=your_postgres_password
    ```

### Application Setup

1. Clone the repository

    ```bash
    git clone https://github.com/Mouayad91/Mini-banking-application.git
    ```

2. Navigate to the project directory

    ```bash
    cd banking_app
    ```

3. Build the project using Maven

    ```bash
    mvn clean install
    ```

4. Run the application

    ```bash
    mvn spring-boot:run
    ```

### Endpoints

The application has the following endpoints:

#### Authentication

- `POST /api/accounts/register` - Register a new user

#### Accounts

- `POST /api/accounts` - Create a new account
- `GET /api/accounts/{id}` - Get account details by ID
- `PUT /api/accounts/{id}/deposit` - Deposit money into an account
- `PUT /api/accounts/{id}/withdraw` - Withdraw money from an account
- `GET /api/accounts` - Get all accounts
- `DELETE /api/accounts/{id}` - Delete an account
- `POST /api/accounts/transfare` - Transfer funds between accounts

## Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Security](https://spring.io/projects/spring-security)
- [JSON Web Tokens (JWT)](https://jwt.io/)
- [PostgreSQL](https://www.postgresql.org/)
- [Lombok](https://projectlombok.org/)
- [AspectJ](https://www.eclipse.org/aspectj/)

