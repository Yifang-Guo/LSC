

# LSC — Department & Employee Management System

A Java web application built with **Spring Boot** that provides core organizational management features such as **department management**, **employee management**, and **authentication**.  
The system also supports **employee avatar uploads to AWS S3**.

This project demonstrates backend development with RESTful APIs, interceptor-based authentication, and external service integration.

---

## 🚀 Features

### 🧑‍💼 Department Management
- View all departments
- Add a new department
- Update an existing department
- Delete a department
- Query department by ID

### 👤 Employee Management
- List all employees
- Add a new employee
- Update employee information
- Delete an employee
- Get employee details by ID
- Upload employee avatar (stored in AWS S3)

### 🔒 Authentication
- Login validation using a Spring **Interceptor**
- Prevents unauthenticated access to protected endpoints

---

## 🛠 Tech Stack

| Technology | Description |
|----------|-------------|
| Java | Core programming language |
| Spring Boot | Backend web framework |
| Maven | Dependency & build management |
| AWS S3 | Cloud storage for avatar images |
| Postman | API testing |

---

## 📂 Project Structure
````
LSC
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.lsc
│   │   │       ├── controller
│   │   │       ├── service
│   │   │       ├── mapper
│   │   │       ├── interceptor
│   │   │       └── config
│   │   └── resources
│   │       ├── application.properties
│   │       └── static
│   └── test
├── pom.xml
└── README.md

````

---

## 🚀 Getting Started

### 📥 Clone the Repository
```bash
git clone https://github.com/Yifang-Guo/LSC.git
cd LSC
````

---

### ⚙️ Configuration

Edit `application.properties` and configure the following:

```properties
# Database
spring.datasource.url=jdbc:...
spring.datasource.username=...
spring.datasource.password=...

# AWS S3
cloud.aws.credentials.accessKey=YOUR_ACCESS_KEY
cloud.aws.credentials.secretKey=YOUR_SECRET_KEY
cloud.aws.region.static=YOUR_REGION
cloud.aws.s3.bucket=YOUR_BUCKET_NAME
```

> ⚠️ Do **not** commit real credentials to GitHub.

---

### ▶️ Build & Run

```bash
./mvnw clean install
./mvnw spring-boot:run
```

The application will start at:

```
http://localhost:8080
```

---

## 📡 API Endpoints

### 🧑‍💼 Departments

| Method | Endpoint            | Description          |
| ------ | ------------------- | -------------------- |
| GET    | `/departments`      | Get all departments  |
| POST   | `/departments`      | Create a department  |
| GET    | `/departments/{id}` | Get department by ID |
| PUT    | `/departments/{id}` | Update department    |
| DELETE | `/departments/{id}` | Delete department    |

---

### 👤 Employees

| Method | Endpoint                 | Description         |
| ------ | ------------------------ | ------------------- |
| GET    | `/employees`             | Get all employees   |
| POST   | `/employees`             | Create an employee  |
| GET    | `/employees/{id}`        | Get employee by ID  |
| PUT    | `/employees/{id}`        | Update employee     |
| DELETE | `/employees/{id}`        | Delete employee     |
| POST   | `/employees/{id}/avatar` | Upload avatar image |

---

## 🧪 Testing

Run tests using:

```bash
./mvnw test
```

API testing can be done using **Postman**.

---

## 📦 Packaging & Deployment

Build a runnable JAR:

```bash
./mvnw package
java -jar target/LSC-0.0.1-SNAPSHOT.jar
```

Possible production improvements:

* Dockerize the application
* Use environment variables for secrets
* Add CI/CD (GitHub Actions)
* Enable HTTPS
* Add logging & monitoring

---

## 🛣 Future Improvements

* JWT-based authentication
* Role-based access control (RBAC)
* Pagination & filtering
* Frontend UI (React / Vue)
* Swagger / OpenAPI documentation

---

## 👨‍💻 Author

**Yifang Guo**
Backend-focused software engineer interested in building clean, scalable systems.

GitHub: [https://github.com/Yifang-Guo](https://github.com/Yifang-Guo)

---

## 📄 License

This project currently does not include a license file.
You may add one depending on usage requirements.

