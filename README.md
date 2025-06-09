# Collaborative Project and Task Manager with Roles and Notifications

## Overview

This project provides a robust REST API for managing collaborative projects, tasks, and users, featuring role-based access control, action auditing, and real-time notifications. It is implemented as a set of microservices, each with its own database, and is ready to be tested with Postman.

---

## Main Features

### 1. User and Role Management
- **User Registration**: Sign up users with assigned roles (e.g., ADMIN, MANAGER, DEVELOPER).
- **Authentication**: Secure login with JWT and refresh token generation.
- **Role-Based Access Control**: Endpoint access is restricted based on roles.
- **User CRUD**: Only ADMINs can create, read, update, or delete users.

### 2. Project Management
- **Project CRUD**: Full create, read, update, and delete operations for projects.
- **Role Restrictions**: Only MANAGER or ADMIN roles can create/modify projects.
- **Project Membership**: Users can be assigned to specific projects.

### 3. Task Management
- **Task CRUD**: Manage tasks within projects.
- **Assignment**: Assign tasks to users and/or groups.
- **Modification Rights**: Only assigned users or ADMIN can modify tasks.

### 4. Auditing and Control
- **Audit Logging**: Automatically track who created/modified each resource and when.
- **History Endpoint**: Query change history logs for audit purposes.

### 5. Notifications (Separate Microservice)
- **Event Generation**: Task creation and updates trigger events.
- **Event Consumption**: Notification microservice listens for events via RabbitMQ or Kafka.
- **User Notification**: Sends simulated notifications (e.g., via logs) to assigned users.

---

## Proposed Architecture

The platform uses a microservices approach, with each service running independently and communicating over REST or asynchronous events:

- **user-service**: Manages users, groups, roles, and authentication.
- **project-service**: Handles project management and group assignments.
- **task-service**: Manages tasks, assignments, and task-specific logic.
- **notification-service**: Consumes events and sends notifications.

**Each microservice has its own PostgreSQL database.**

- Synchronous communication: REST API between microservices.
- Asynchronous communication: RabbitMQ or Kafka for notification events.

---

## Technologies and Concepts

- **Spring Boot & Spring Security**
- **JWT Authentication and Refresh Tokens**
- **Spring Data JPA & JPA Auditing**
- **JUnit & Mockito** for unit/integration testing
- **Docker & Docker Compose** for containerization
- **Basic Kubernetes** (Minikube or cloud provider)
- **RabbitMQ or Kafka** for event-driven communication
- **Swagger/OpenAPI** for API documentation
- **Postman** for API testing

---

## Entity-Relationship (ER) Model

### Users
- Unique identifier, name, email, and personal details
- Can belong to multiple groups, each with a different role (ADMIN, EDITOR, DEVELOPER)
- Role assignment is contextual to the group

### Roles
- Predefined: ADMIN, EDITOR, DEVELOPER
- Assigned per user/group context

### Groups
- Each group belongs to a single project
- Has a name and includes multiple users
- Users can belong to multiple groups (each group linked to one project)

### Projects
- Unique identifier, name, description, creation date
- Composed of one or more groups
- Can have multiple associated tasks

### Tasks
- Belong to a single project
- Assigned to a group and/or one or more users
- Properties: title, description, status (pending, in progress, finished), priority, due date
- Auditing: records both creator/updater and timestamps

### Tags
- Tasks can have zero or more tags for classification
- Tag: unique name, optional description

---

## Getting Started

### Prerequisites
- Docker & Docker Compose
- Java 17+
- PostgreSQL
- RabbitMQ or Kafka (for notifications)
- Postman

### Running the Services
1. Clone the repository.
2. Configure environment variables for each service (see `/config` or sample `.env` files).
3. Use Docker Compose to start all services:
   ```bash
   docker-compose up --build
   ```
4. Access Swagger UI for API documentation at each service's `/swagger-ui.html`.

### Testing the API
- Use provided Postman collections to test all endpoints.
- Ensure RabbitMQ/Kafka is running for notifications.

---

## Documentation

- **Swagger/OpenAPI** endpoints are available for each microservice.
- Use Postman collections for quick testing and demonstration.

---

## Contribution

Contributions are welcome! Please fork the repository, create a feature branch, and submit a pull request.
