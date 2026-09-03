# E-Commerce Order Management System

## Project Overview

The **E-Commerce Order Management System** is a Java-based application designed to manage product inventory, customer orders, and payments efficiently.

Built using **Hexagonal Architecture (Ports & Adapters)**, the system ensures a clean separation between business logic and infrastructure, making it scalable, maintainable, and testable.

---

## Project Structure

The project follows **Hexagonal Architecture** to separate core business logic from external dependencies such as databases, APIs, and messaging systems.

```text
ecommerce-order-system/
│
├── application/       # Business logic (Use Cases)
├── domain/            # Entities, Aggregates, Value Objects
├── infrastructure/    # Hibernate, Database, REST Adapters, Messaging
├── configuration/     # Spring Boot Configurations
└── main/              # Application Entry Point
```

---

## Tech Stack

The application is built using the following technologies:

- **Java (Spring Boot)** - Backend framework for building RESTful APIs.
- **Hibernate (JPA)*
