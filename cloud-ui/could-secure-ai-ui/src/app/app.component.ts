import { Component } from '@angular/core';

interface LoginData {
  email: string;
  password: string;
}

interface SignupData {
  fullName: string;
  email: string;
  password: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'could-secure-ai-ui';
  showLoginModal = false;
  showSignupModal = false;
  
  loginData: LoginData = {
    email: '',
    password: ''
  };
  
  signupData: SignupData = {
    fullName: '',
    email: '',
    password: ''
  };

  showLogin() {
    this.showLoginModal = true;
    this.showSignupModal = false;
  }

  showSignup() {
    this.showSignupModal = true;
    this.showLoginModal = false;
  }

  closeModal(event?: Event) {
    this.showLoginModal = false;
    this.showSignupModal = false;
  }

  onLogin() {
    console.log('Login attempt:', this.loginData);
    // Here you would typically call an authentication service
    alert(`Welcome back, ${this.loginData.email}!`);
    this.closeModal();
    // Reset form
    this.loginData = { email: '', password: '' };
  }

  onSignup() {
    console.log('Signup attempt:', this.signupData);
    // Here you would typically call a registration service
    alert(`Welcome to CouldSecureAI, ${this.signupData.fullName}!`);
    this.closeModal();
    // Reset form
    this.signupData = { fullName: '', email: '', password: '' };
  }

  startTrial() {
    this.showSignup();
  }

  watchDemo() {
    alert('Demo video coming soon!');
  }
}
