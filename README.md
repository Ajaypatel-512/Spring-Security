# 📘 Spring Data JPA – Proof of Concept (POC)

This project demonstrates the usage of **Spring Data JPA** with **MySQL** using a **Test-Driven Development (TDD)** approach. It covers practical use cases of entity relationships, JPA annotations, and CRUD operations through unit tests.

---

## 🚀 Features

### 🔍 Entities Implemented:
- `Student`
- `Guardian` (as embedded in Student)
- `Course`
- `CourseMaterial`
- `Teacher`

### 🔗 Relationships Covered:
- **One-to-One**: `Course` ↔ `CourseMaterial`
- **One-to-Many**: `Teacher` → `Course`
- **Many-to-One**: `Course` → `Teacher`
- **Many-to-Many**: `Student` ↔ `Course`
- **Embedded**: `Guardian` inside `Student`

---

## 🛠️ Technologies Used
- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **JUnit 5**
- **Maven**

---

## 🧪 Test-Driven Development

All repository operations are tested using unit tests:
- Save, update, delete, and fetch operations
- Relationship and cascading validations
- Custom queries

---

## ⚙️ Setup Instructions

### 📦 Clone the Repository
```bash
git clone https://github.com/<your-username>/spring-data-jpa-poc.git
cd spring-data-jpa-poc
