#  Distributed Inventory Management Platform
**A Microservices-based Enterprise Stock Control System**

This project is a high-availability, distributed inventory management system built with **Java 17** and **Spring Boot 3**. It utilizes a microservices architecture to decouple concerns across authentication, inventory tracking, and real-time notifications.

---

##  System Architecture
The system is composed of five distinct services, fully containerized using **Docker**:

1.  **API Gateway (Port 8080):** The single entry point. Handles request routing and load balancing using **Spring Cloud Gateway**.
2.  **Auth Service (Port 8081):** Manages system access and security logic.
3.  **Notification Service (Port 8082):** Listens for low-stock events and triggers real-time alerts.
4.  **Inventory Service (Port 8083):** The core business logic service. Manages product data and provides the web interface.
5.  **Web Dashboard:** An integrated UI built with **Thymeleaf** and **Bootstrap 5** for real-time monitoring.

---

##  Technology Stack

### >> Backend
* **Java 17 & Spring Boot 3:** Core framework.
* **Spring Cloud Gateway:** Dynamic routing and path rewriting.
* **Spring Security:** Basic Authentication and route protection.
* **Spring Data JPA:** Object-Relational Mapping for database interactions.

### >> Database
* **H2 Database:** In-memory persistence for high-speed development and testing.
* **SQL Seeding:** Automated data injection via `data.sql` for consistent demo environments.

### >> Frontend
* **Thymeleaf:** Server-side template engine for dynamic HTML rendering.
* **Bootstrap 5:** Responsive CSS framework for a modern "Enterprise Dark" UI.
* **Jakarta Sans:** Premium typography for improved UX.

### >> DevOps & Tools
* **Docker & Docker Compose:** Full system containerization.
* **Maven:** Dependency management and build automation.
* **Postman:** API testing and documentation.

---

## >> Getting Started

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/omarbaasharalt/distributed-inventory-system.git]
   (https://github.com/omarbaasharalt/distributed-inventory-system.git)

      cd distributed-inventory-system

      mvn clean package -DskipTests

      docker compose up --build -d