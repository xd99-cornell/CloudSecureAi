import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AdminComponent } from './components/admin/admin.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'cloud-accounts', component: DashboardComponent }, // Placeholder for now
  { path: 'resources', component: DashboardComponent }, // Placeholder for now
  { path: 'compliance', component: DashboardComponent }, // Placeholder for now
  { path: 'vulnerabilities', component: DashboardComponent }, // Placeholder for now
  { path: 'k8s-clusters', component: DashboardComponent }, // Placeholder for now
  { path: 'container-images', component: DashboardComponent }, // Placeholder for now
  { path: 'code-security', component: DashboardComponent }, // Placeholder for now
  { path: 'reports', component: DashboardComponent }, // Placeholder for now
  { path: 'settings', component: AdminComponent }, // Reuse admin for settings
  { path: 'profile', component: AdminComponent } // Placeholder for profile
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
