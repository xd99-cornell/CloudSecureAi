import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AdminComponent } from './components/admin/admin.component';
import { CloudAccountsComponent } from './components/cloud-accounts/cloud-accounts.component';
import { ResourcesComponent } from './components/resources/resources.component';
import { ComplianceComponent } from './components/compliance/compliance.component';
import { VulnerabilitiesComponent } from './components/vulnerabilities/vulnerabilities.component';
import { K8sClustersComponent } from './components/k8s-clusters/k8s-clusters.component';
import { ContainerImagesComponent } from './components/container-images/container-images.component';
import { CodeSecurityComponent } from './components/code-security/code-security.component';
import { ReportsComponent } from './components/reports/reports.component';
import { ProfileComponent } from './components/profile/profile.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'cloud-accounts', component: CloudAccountsComponent },
  { path: 'resources', component: ResourcesComponent },
  { path: 'compliance', component: ComplianceComponent },
  { path: 'vulnerabilities', component: VulnerabilitiesComponent },
  { path: 'k8s-clusters', component: K8sClustersComponent },
  { path: 'container-images', component: ContainerImagesComponent },
  { path: 'code-security', component: CodeSecurityComponent },
  { path: 'reports', component: ReportsComponent },
  { path: 'settings', component: AdminComponent },
  { path: 'profile', component: ProfileComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
