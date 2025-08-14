# Task Manager

This project is a Task Manager API built with Spring Boot.

## Features

- Task CRUD (create, list, update, delete)
- Data validation
- Exception handling
- Persistence with Spring Data JPA

## Project Structure

- `controller/` — REST endpoints
- `service/` — Business logic
- `repository/` — Database integration
- `model/entity/` — JPA entities
- `model/request/` — Request DTOs
- `exception/` — Custom exceptions and handlers

## How to Run

1. Clone the repository
2. Configure your database in `src/main/resources/application.yaml`
3. Run the project:
	 ```bash
	 ./mvnw spring-boot:run
	 ```
4. Access the API at `http://localhost:8080`

## Main Endpoints

### Create Task
`POST /tasks`
```json
{
	"title": "New task",
	"description": "Task description"
}
```

### List Tasks
`GET /tasks`

### Get Task by ID
`GET /tasks/{id}`

## Testing

Run tests with:
```bash
./mvnw test
```

## Requirements

- Java 21+
- Maven

## Author

- sensuy
