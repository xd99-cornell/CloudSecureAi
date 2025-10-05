import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
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

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    AdminComponent,
    CloudAccountsComponent,
    ResourcesComponent,
    ComplianceComponent,
    VulnerabilitiesComponent,
    K8sClustersComponent,
    ContainerImagesComponent,
    CodeSecurityComponent,
    ReportsComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
