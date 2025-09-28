# CloudSecure AI Backend Service

A Spring Boot backend service with JWT-based authentication, user management, and protected pages.

## Features

- 🔐 **JWT Authentication**: Secure token-based authentication
- 👤 **User Management**: Registration, login, and profile management
- 🛡️ **Role-Based Access Control**: USER and ADMIN roles
- 📱 **Responsive Web UI**: Modern Bootstrap-based interface
- 🔒 **Protected Endpoints**: Secure API endpoints and pages
- 💾 **H2 Database**: In-memory database for development
- 📊 **Admin Panel**: Administrative interface for system management

## Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Running the Application

1. **Clone and navigate to the backend service directory:**
   ```bash
   cd backend-service
   ```

2. **Build the application:**
   ```bash
   mvn clean package
   ```

3. **Run the JAR file:**
   ```bash
   java -jar target/backend-service-1.0.0.jar
   ```

4. **Access the application:**
   - Main page: http://localhost:8080/api/
   - Login: http://localhost:8080/api/login
   - Register: http://localhost:8080/api/register
   - H2 Console: http://localhost:8080/api/h2-console

### Default Users

The application creates default users on startup:

**Admin User:**
- Username: `admin`
- Password: `admin123`
- Email: `admin@cloudsecure.com`
- Role: ADMIN

**Regular User:**
- Username: `user`
- Password: `user123`
- Email: `user@cloudsecure.com`
- Role: USER

## API Endpoints

### Authentication Endpoints
- `POST /api/auth/login` - User login
- `POST /api/auth/register` - User registration

### Protected Endpoints (Require Authentication)
- `GET /api/api/user/profile` - Get user profile
- `GET /api/api/user/test` - Test user access
- `GET /api/api/user/admin` - Test admin access (ADMIN only)

### Web Pages
- `/api/` - Home page
- `/api/login` - Login page
- `/api/register` - Registration page
- `/api/dashboard` - User dashboard (protected)
- `/api/admin` - Admin panel (ADMIN only)

## Authentication Flow

1. **Registration/Login**: Users can register or login through the web interface
2. **JWT Token**: Upon successful authentication, a JWT token is issued
3. **Token Storage**: The frontend stores the token in localStorage
4. **Protected Access**: The token is sent in the Authorization header for protected requests
5. **Role-Based Access**: Different endpoints require different roles (USER/ADMIN)

## Configuration

Key configuration properties in `application.yml`:

```yaml
server:
  port: 8080
  servlet:
    context-path: /api

jwt:
  secret: mySecretKey123456789012345678901234567890
  expiration: 86400000 # 24 hours

spring:
  datasource:
    url: jdbc:h2:mem:testdb
    username: sa
    password: password
```

## Database

The application uses H2 in-memory database for development. You can access the H2 console at:
- URL: http://localhost:8080/api/h2-console
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: `password`

## Security Features

- **Password Encryption**: BCrypt password hashing
- **JWT Tokens**: Secure token-based authentication
- **CORS Configuration**: Cross-origin resource sharing support
- **Role-Based Authorization**: Method-level security with roles
- **Session Management**: Stateless session management

## Development

### Building from Source
```bash
mvn clean compile
```

### Running Tests
```bash
mvn test
```

### Creating JAR
```bash
mvn clean package
```

The JAR file will be created in the `target/` directory.

## Architecture

```
├── src/main/java/com/cloudsecure/backend/
│   ├── config/          # Configuration classes
│   ├── controller/      # REST controllers and web controllers
│   ├── dto/            # Data Transfer Objects
│   ├── entity/         # JPA entities
│   ├── repository/     # Data repositories
│   ├── security/       # Security components (JWT, filters)
│   └── service/        # Business logic services
├── src/main/resources/
│   ├── static/         # Static web resources (CSS, JS)
│   ├── templates/      # Thymeleaf templates
│   └── application.yml # Application configuration
└── pom.xml            # Maven configuration
```

## License

This project is part of the CloudSecure AI system.
