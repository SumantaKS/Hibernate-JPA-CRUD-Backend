# Hibernate/JPA CRUD (Backend) (Spring 6 / Spring Boot 3 / Maven)

- **Description**: A backend application using Hibernate/JPA for CRUD operations on student data.

- **Architecture Diagram**: CRUD App <--> Student DAO <--> JPA Entity Manager <--> Data Source <--> Database

- **Usage**:
  - Uses a Student DAO for database interactions.
  - DAO provides an abstract interface to the database.
  - DAO utilizes the JPA Entity Manager.
  - JPA Entity Manager and Data Source are auto-created by Spring Boot.
  - Data Source is a factory for database connections.
  - JPA Entity Manager can be autowired/injected into the Student DAO.
  - DAO is also injected into a `CommandLineRunner` bean, allowing database operations to be performed as soon as the application is run.

- **Development Process**:
  1. Define DAO interface.
  2. Define DAO implementation (Inject JPA Entity Manager).
  3. Update Main app.
