import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from '../../services/auth.service';
import { User } from '../../models/auth.model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  currentUser: User | null = null;
  apiResponse: string = '';
  private apiUrl = 'http://localhost:8080/api';

  constructor(
    private authService: AuthService,
    private router: Router,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.currentUser = this.authService.currentUserValue;
    
    if (!this.authService.isAuthenticated()) {
      this.router.navigate(['/home']);
      return;
    }

    // Load complete user profile
    this.authService.getProfile().subscribe({
      next: (user) => {
        this.currentUser = user;
      },
      error: (error) => {
        console.error('Error loading profile:', error);
        if (error.status === 401) {
          this.authService.logout();
          this.router.navigate(['/home']);
        }
      }
    });
  }

  get isAdmin(): boolean {
    return this.authService.isAdmin();
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/home']);
  }

  goToAdmin(): void {
    this.router.navigate(['/admin']);
  }

  loadUserProfile(): void {
    this.authService.getProfile().subscribe({
      next: (user) => {
        this.apiResponse = JSON.stringify(user, null, 2);
      },
      error: (error) => {
        this.apiResponse = `Error: ${error.message}`;
      }
    });
  }

  testProtectedAPI(): void {
    const token = this.authService.getToken();
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    
    this.http.get(`${this.apiUrl}/api/user/test`, { headers, responseType: 'text' }).subscribe({
      next: (response) => {
        this.apiResponse = response;
      },
      error: (error) => {
        this.apiResponse = `Error: ${error.message}`;
      }
    });
  }
}