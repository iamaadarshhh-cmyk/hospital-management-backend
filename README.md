# 🏥 Hospital Management System – Backend

A robust and scalable **Spring Boot REST API** for managing hospital operations including patients, doctors, and appointments. Designed with clean architecture, security, and production-ready best practices.

---

## 🚀 Features

### 🔐 Authentication & Security
- JWT-based authentication
- Secure password hashing using BCrypt
- Protected REST endpoints
- Scalable role-based authorization (extendable)

### 👨‍⚕️ Doctor Management
- Create, update, delete, and retrieve doctors
- Manage doctor specialties

### 🧑 Patient Management
- Full CRUD operations
- Input validation using annotations

### 📅 Appointment Management
- Schedule appointments between doctors and patients
- Conflict detection to prevent double booking
- Pagination support for large datasets

### 📦 Architecture & Design
- Layered architecture (Controller → Service → Repository)
- DTO pattern for clean API design
- Clean, maintainable, and scalable codebase

### 📄 API Documentation
- Swagger/OpenAPI integration for easy API testing

---

## 🛠 Tech Stack

- **Backend:** Spring Boot
- **Security:** Spring Security + JWT
- **Database:** PostgreSQL
- **ORM:** JPA / Hibernate
- **Build Tool:** Maven
- **Utilities:** Lombok
- **API Docs:** Springdoc OpenAPI (Swagger)

---

## 📂 Project Structure

```
com.HospitalManagement
│
├── controller       # REST Controllers
├── service          # Business Logic Layer
├── repository       # Data Access Layer
├── entity           # Database Entities
├── dto              # Data Transfer Objects
├── config           # Security & Application Config
├── security         # JWT & Authentication Logic
└── exception        # Global Exception Handling (optional)
```

---

## 🔑 Authentication Flow

1. User sends login request (`/auth/login`)
2. Server validates credentials
3. JWT token is generated
4. Token is returned to client
5. Client sends token in headers for secured APIs

**Header Format:**
```
Authorization: Bearer <your_token>
```

---

## 📌 API Endpoints

### 🔐 Authentication
- `POST /auth/login` → Authenticate user and receive JWT

### 👨‍⚕️ Doctors
- `POST /doctors`
- `GET /doctors`
- `PUT /doctors/{id}`
- `DELETE /doctors/{id}`

### 🧑 Patients
- `POST /patients`
- `GET /patients`
- `PUT /patients/{id}`
- `DELETE /patients/{id}`

### 📅 Appointments
- `POST /appointments`
- `GET /appointments`

---

## ⚙️ Setup & Installation

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/your-username/hospital-management-backend.git
cd hospital-management-backend
```

---

### 2️⃣ Configure Database

Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hospital_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 3️⃣ Run the Application
```bash
mvn spring-boot:run
```

---

### 4️⃣ Access Swagger UI
```
http://localhost:8080/swagger-ui.html
```

---

## 🧪 Testing APIs

You can test APIs using:
- Postman
- Swagger UI

For secured endpoints, include JWT token:

```
Authorization: Bearer <token>
```

---

## ⚡ Future Improvements

- Role-based access control (Admin / Doctor / Patient)
- Email notifications for appointments
- Docker containerization
- CI/CD pipeline integration
- Audit logging
- Frontend integration (React / Angular)

---

## 🤝 Contributing

Contributions are welcome!  
Feel free to fork this repository and submit pull requests.

---


## 👨‍💻 Author

**Adarsh Yadav**

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!
