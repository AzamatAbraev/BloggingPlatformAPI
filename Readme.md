# Personal Blogging Platform API

## Overview
This is a simple RESTful API for a personal blogging platform that supports CRUD operations for blog posts. The API follows REST best practices and provides endpoints to create, read, update, delete, and search blog posts.

## Features
- Create a new blog post
- Update an existing blog post
- Delete an existing blog post
- Retrieve a single blog post
- Retrieve all blog posts
- Filter blog posts by a search term

## Technologies Used
- **Spring Boot** (Framework)
- **Spring Data JPA** (ORM for database interactions)
- **PostgreSQL** (Database)
- **Maven** (Dependency management)

## API Endpoints

### 1. Create a Blog Post
**Endpoint:** `POST /posts`

**Request Body:**
```json
{
  "title": "My First Blog Post",
  "content": "This is the content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"]
}
```

**Response:**
```json
{
  "id": 1,
  "title": "My First Blog Post",
  "content": "This is the content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"],
  "createdAt": "2025-02-01T12:00:00Z",
  "updatedAt": "2025-02-01T12:00:00Z"
}
```
**Status Codes:**
- `201 Created` (Success)
- `400 Bad Request` (Validation errors)

---

### 2. Update a Blog Post
**Endpoint:** `PUT /posts/{id}`

**Request Body:**
```json
{
  "title": "My Updated Blog Post",
  "content": "This is the updated content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"]
}
```

**Response:**
```json
{
  "id": 1,
  "title": "My Updated Blog Post",
  "content": "This is the updated content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"],
  "createdAt": "2021-09-01T12:00:00Z",
  "updatedAt": "2021-09-01T12:30:00Z"
}
```
**Status Codes:**
- `200 OK` (Success)
- `400 Bad Request` (Validation errors)
- `404 Not Found` (If post does not exist)

---

### 3. Delete a Blog Post
**Endpoint:** `DELETE /posts/{id}`

**Response:**
- `204 No Content` (Success)
- `404 Not Found` (If post does not exist)

---

### 4. Retrieve a Single Blog Post
**Endpoint:** `GET /posts/{id}`

**Response:**
```json
{
  "id": 1,
  "title": "My First Blog Post",
  "content": "This is the content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"],
  "createdAt": "2025-03-01T12:00:00Z",
  "updatedAt": "2025-03-01T12:00:00Z"
}
```
**Status Codes:**
- `200 OK` (Success)
- `404 Not Found` (If post does not exist)

---

### 5. Retrieve All Blog Posts
**Endpoint:** `GET /posts`

**Response:**
```json
[
  {
    "id": 1,
    "title": "My First Blog Post",
    "content": "This is the content of my first blog post.",
    "category": "Technology",
    "tags": ["Tech", "Programming"],
    "createdAt": "2025-03-01T12:00:00Z",
    "updatedAt": "2025-03-01T12:00:00Z"
  },
  {
    "id": 2,
    "title": "My Second Blog Post",
    "content": "This is the content of my second blog post.",
    "category": "Technology",
    "tags": ["Tech", "Programming"],
    "createdAt": "2025-03-01T12:30:00Z",
    "updatedAt": "2025-03-01T12:30:00Z"
  }
]
```
**Status Codes:**
- `200 OK` (Success)

---

### 6. Search Blog Posts
**Endpoint:** `GET /posts?term={searchTerm}`

**Example:** `GET /posts?term=tech`

**Response:**
```json
[
  {
    "id": 1,
    "title": "Tech Trends 2024",
    "content": "Latest technology trends for 2024...",
    "category": "Technology",
    "tags": ["Tech", "Innovation"],
    "createdAt": "2025-03-01T10:00:00Z",
    "updatedAt": "2025-03-01T10:00:00Z"
  }
]
```
**Status Codes:**
- `200 OK` (Success)

## Setup & Running Locally
### Prerequisites
- Java 17+
- Maven
- PostgreSQL/

### Steps
1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/blogging-platform-api.git
   cd blogging-platform-api
   ```
2. Configure database settings in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/db_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Run the application:
   ```sh
   mvn spring-boot:run
   ```
4. The API will be available at `http://localhost:8080`.

