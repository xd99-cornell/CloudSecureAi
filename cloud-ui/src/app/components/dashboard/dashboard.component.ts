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

  // Dashboard metrics
  totalAccounts = 12;
  securityScore = 85;
  totalScans = 247;
  criticalAlerts = 3;
  highRiskResources = 15;
  mediumRiskResources = 42;
  compliantResources = 183;
  complianceScore = 78;

  // Recent activities data
  recentActivities = [
    {
      title: 'AWS Account Security Scan',
      time: '2 hours ago',
      result: 'Completed',
      status: 'success'
    },
    {
      title: 'Azure Compliance Check',
      time: '4 hours ago',
      result: 'Warning',
      status: 'warning'
    },
    {
      title: 'GCP Resource Assessment',
      time: '6 hours ago',
      result: 'Completed',
      status: 'success'
    },
    {
      title: 'K8s Vulnerability Scan',
      time: '8 hours ago',
      result: 'Failed',
      status: 'critical'
    }
  ];

  // Cloud providers data
  cloudProviders = [
    {
      name: 'Amazon Web Services',
      icon: '🟡',
      accounts: 5,
      status: 'connected'
    },
    {
      name: 'Microsoft Azure',
      icon: '🔵',
      accounts: 3,
      status: 'connected'
    },
    {
      name: 'Google Cloud Platform',
      icon: '🔴',
      accounts: 2,
      status: 'connected'
    },
    {
      name: 'Alibaba Cloud',
      icon: '🟠',
      accounts: 2,
      status: 'disconnected'
    }
  ];

  constructor(
    private authService: AuthService,
    private router: Router,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.currentUser = this.authService.currentUserValue;
    
    if (!this.authService.isAuthenticated()) {
      this.router.navigate(['/']);
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
          this.router.navigate(['/']);
        }
      }
    });

    // Load dashboard data
    this.loadDashboardData();
  }

  loadDashboardData(): void {
    // In a real application, this would make API calls to fetch dashboard data
    // For now, we'll use mock data
    console.log('Loading dashboard data...');
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