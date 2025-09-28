# CloudSecure AI - Integrated Full-Stack Application

A complete full-stack application with Angular frontend and Spring Boot backend, featuring JWT authentication and role-based access control.

## 🏗️ Architecture

```
┌─────────────────────┐    HTTP/REST API    ┌─────────────────────┐
│   Angular Frontend  │ ←─────────────────→ │ Spring Boot Backend │
│   (Port 4200)       │                     │   (Port 8080)       │
│                     │                     │                     │
│ • Home Page         │                     │ • JWT Authentication│
│ • Authentication    │                     │ • User Management   │
│ • Dashboard         │                     │ • Protected APIs    │
│ • Admin Panel       │                     │ • H2 Database       │
└─────────────────────┘                     └─────────────────────┘
```

## ✨ Features

### Frontend (Angular)
- 🎨 **Modern UI**: Responsive design with Bootstrap 5
- 🔐 **Authentication**: Login/Register modals with real-time validation
- 📊 **Dashboard**: Protected user dashboard with API testing
- ⚙️ **Admin Panel**: Administrative interface for system management
- 🔄 **Real-time Updates**: JWT token management and auto-logout

### Backend (Spring Boot)
- 🛡️ **JWT Security**: Token-based authentication with role-based access
- 📡 **REST API**: Complete API endpoints for authentication and user management
- 🗄️ **Database**: H2 in-memory database with JPA/Hibernate
- 🌐 **CORS**: Configured for Angular frontend integration
- 👥 **User Roles**: USER and ADMIN role-based access control

## 🚀 Quick Start

### Prerequisites
- Node.js 16+ and npm
- Java 17+
- Maven 3.6+

### 1. Start the Backend Service

```bash
cd backend-service
mvn clean package -DskipTests
java -jar target/backend-service-1.0.0.jar
```

The backend will start on `http://localhost:8080`

### 2. Start the Angular Frontend

```bash
cd cloud-ui/could-secure-ai-ui
npm install
ng serve
```

The frontend will start on `http://localhost:4200`

### 3. Access the Application

Open your browser and navigate to: **http://localhost:4200**

## 🔑 Default Users

The application comes with pre-configured users:

| Username | Password | Role  | Email |
|----------|----------|-------|-------|
| `admin`  | `admin123` | ADMIN | admin@cloudsecure.com |
| `user`   | `user123`  | USER  | user@cloudsecure.com |

## 📱 Application Flow

1. **Home Page**: Landing page with authentication modals
2. **Login/Register**: JWT-based authentication with backend integration
3. **Dashboard**: Protected area showing user profile and API testing
4. **Admin Panel**: Administrative functions (ADMIN role only)

## 🔧 API Endpoints

### Authentication
- `POST /api/auth/login` - User login
- `POST /api/auth/register` - User registration

### Protected Endpoints (Require JWT Token)
- `GET /api/api/user/profile` - Get user profile
- `GET /api/api/user/test` - Test user access
- `GET /api/api/user/admin` - Admin-only endpoint

### Development Tools
- `GET /api/h2-console` - H2 Database Console

## 🛠️ Development

### Frontend Development
```bash
cd cloud-ui/could-secure-ai-ui
ng serve --open
```

### Backend Development
```bash
cd backend-service
mvn spring-boot:run
```

### Building for Production

**Frontend:**
```bash
cd cloud-ui/could-secure-ai-ui
ng build --prod
```

**Backend:**
```bash
cd backend-service
mvn clean package
```

## 🔒 Security Features

- **JWT Authentication**: Secure token-based authentication
- **Password Encryption**: BCrypt password hashing
- **CORS Configuration**: Properly configured for frontend-backend communication
- **Role-Based Access**: Different access levels for USER and ADMIN roles
- **Protected Routes**: Frontend route guards for authenticated pages
- **Token Management**: Automatic token storage and cleanup

## 🗄️ Database

The application uses H2 in-memory database for development:
- **Console**: http://localhost:8080/api/h2-console
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`

## 📁 Project Structure

```
CouldSecureAI/
├── backend-service/          # Spring Boot Backend
│   ├── src/main/java/
│   │   └── com/cloudsecure/backend/
│   │       ├── config/       # Security & CORS configuration
│   │       ├── controller/   # REST API controllers
│   │       ├── dto/          # Data Transfer Objects
│   │       ├── entity/       # JPA entities
│   │       ├── repository/   # Data repositories
│   │       ├── security/     # JWT utilities
│   │       └── service/      # Business logic
│   └── pom.xml
├── cloud-ui/could-secure-ai-ui/  # Angular Frontend
│   ├── src/app/
│   │   ├── components/       # Angular components
│   │   ├── models/          # TypeScript interfaces
│   │   └── services/        # Angular services
│   └── package.json
└── README.md
```

## 🧪 Testing the Integration

1. **Start both services** (backend on 8080, frontend on 4200)
2. **Open http://localhost:4200**
3. **Click "Login"** and use `admin` / `admin123`
4. **Navigate to Dashboard** to see protected content
5. **Test API endpoints** using the dashboard buttons
6. **Access Admin Panel** (admin users only)

## 🎯 Key Integration Points

- **Authentication Flow**: Angular → Spring Boot JWT API
- **CORS Configuration**: Backend allows Angular origin (localhost:4200)
- **Token Management**: Angular stores JWT tokens and includes in API calls
- **Error Handling**: Proper error messages and automatic logout on token expiry
- **Role-Based UI**: Different UI elements based on user role

## 📝 Notes

- The backend serves **only API endpoints** - no web pages
- The Angular app handles **all UI rendering**
- JWT tokens expire after 24 hours
- H2 database resets on application restart
- CORS is configured specifically for development (localhost:4200)

---

**🎉 Your CloudSecure AI application is now fully integrated and ready to use!**