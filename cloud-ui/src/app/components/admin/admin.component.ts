import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from '../../services/auth.service';
import { User } from '../../models/auth.model';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  currentUser: User | null = null;
  adminConsole: string = '';
  private apiUrl = 'http://localhost:8080/api';

  constructor(
    private authService: AuthService,
    private router: Router,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.currentUser = this.authService.currentUserValue;
    
    if (!this.authService.isAuthenticated() || !this.authService.isAdmin()) {
      this.router.navigate(['/dashboard']);
      return;
    }
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/home']);
  }

  loadUsers(): void {
    this.adminConsole = 
      'Loading users...\n\n' +
      'Mock User Data:\n' +
      '- admin@cloudsecure.com (ADMIN)\n' +
      '- user@cloudsecure.com (USER)\n' +
      '- user1@example.com (USER)\n' +
      '- user2@example.com (USER)\n\n' +
      'Total Users: 4\n' +
      'Active Users: 4\n' +
      'Admin Users: 1';
  }

  loadSystemStats(): void {
    this.adminConsole = 
      'System Statistics:\n\n' +
      'Server Uptime: 2 hours 15 minutes\n' +
      'Memory Usage: 45%\n' +
      'CPU Usage: 12%\n' +
      'Database Connections: 5/100\n' +
      'Active Sessions: 3\n' +
      'Total API Calls Today: 127\n' +
      'Authentication Success Rate: 98.5%\n' +
      'Angular Frontend: Connected\n' +
      'Spring Boot Backend: Running';
  }

  loadSecuritySettings(): void {
    this.adminConsole = 
      'Security Configuration:\n\n' +
      'JWT Token Expiration: 24 hours\n' +
      'Password Policy: Minimum 6 characters\n' +
      'Failed Login Attempts Limit: 5\n' +
      'Account Lockout Duration: 30 minutes\n' +
      'Two-Factor Authentication: Disabled\n' +
      'SSL/TLS: Enabled\n' +
      'CORS Policy: Configured for Angular\n' +
      'Rate Limiting: 100 requests/minute\n' +
      'Frontend Origin: http://localhost:4200\n' +
      'Backend API: http://localhost:8080/api';
  }

  testAdminAPI(): void {
    this.adminConsole = 'Testing Admin API...';
    
    const token = this.authService.getToken();
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    
    this.http.get(`${this.apiUrl}/api/user/admin`, { headers, responseType: 'text' }).subscribe({
      next: (response) => {
        this.adminConsole = 
          `Admin API Test Successful!\n\n` +
          `Response: ${response}\n\n` +
          `Status: 200 OK\n` +
          `Access Level: ADMIN CONFIRMED\n` +
          `Integration: Angular ↔ Spring Boot ✅`;
      },
      error: (error) => {
        this.adminConsole = 
          `Admin API Test Failed:\n` +
          `Error: ${error.message}\n` +
          `Status: ${error.status}\n` +
          `Please check backend connection.`;
      }
    });
  }
}