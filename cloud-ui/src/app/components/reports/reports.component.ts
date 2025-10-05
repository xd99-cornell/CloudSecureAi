import { Component, OnInit } from '@angular/core';

interface SummaryCard {
  id: string;
  title: string;
  value: string;
  subtitle: string;
  icon: string;
  color: 'green' | 'yellow' | 'red' | 'blue';
  trend: 'up' | 'down' | 'stable';
  trendValue: string;
}

interface CloudProvider {
  name: string;
  accounts: number;
  issues: number;
  compliance: number;
  lastScan: string;
  status: 'good' | 'medium' | 'critical';
  icon: string;
  color: string;
  expanded: boolean;
  details: {
    resources: number;
    vulnerabilities: number;
    cost: number;
    region: string;
  };
}


interface VulnerabilityData {
  severity: string;
  count: number;
  color: string;
}

interface ResourceData {
  status: string;
  count: number;
  color: string;
}

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit {
  summaryCards: SummaryCard[] = [];
  cloudProviders: CloudProvider[] = [];
  vulnerabilityData: VulnerabilityData[] = [];
  resourceData: ResourceData[] = [];
  
  // Chart data
  pieChartData: any = {};
  barChartData: any = {};

  constructor() {}

  ngOnInit() {
    this.loadSummaryCards();
    this.loadCloudProviders();
    this.loadChartData();
  }

  loadSummaryCards() {
    this.summaryCards = [
      {
        id: 'cloud-accounts',
        title: 'Cloud Accounts',
        value: '3 Clouds Connected',
        subtitle: '1 with issues',
        icon: '☁️',
        color: 'yellow',
        trend: 'up',
        trendValue: '+1 this week'
      },
      {
        id: 'resources',
        title: 'Resources Monitored',
        value: '245 Resources',
        subtitle: '97% Secure',
        icon: '🧩',
        color: 'green',
        trend: 'up',
        trendValue: '+12 today'
      },
      {
        id: 'compliance',
        title: 'Compliance Score',
        value: '82/100',
        subtitle: 'Good Standing',
        icon: '🧠',
        color: 'green',
        trend: 'up',
        trendValue: '+3 this month'
      },
      {
        id: 'vulnerabilities',
        title: 'Vulnerabilities Found',
        value: '37 Total',
        subtitle: '5 High, 12 Medium, 20 Low',
        icon: '🔍',
        color: 'yellow',
        trend: 'down',
        trendValue: '-2 this week'
      }
    ];
  }

  loadCloudProviders() {
    this.cloudProviders = [
      {
        name: 'AWS',
        accounts: 2,
        issues: 3,
        compliance: 88,
        lastScan: 'Oct 3, 2025',
        status: 'medium',
        icon: '🟠',
        color: '#FF9900',
        expanded: false,
        details: {
          resources: 156,
          vulnerabilities: 8,
          cost: 1247.50,
          region: 'us-east-1, us-west-2'
        }
      },
      {
        name: 'Azure',
        accounts: 1,
        issues: 1,
        compliance: 93,
        lastScan: 'Oct 4, 2025',
        status: 'good',
        icon: '🔵',
        color: '#0078D4',
        expanded: false,
        details: {
          resources: 67,
          vulnerabilities: 3,
          cost: 892.30,
          region: 'East US, West Europe'
        }
      },
      {
        name: 'GCP',
        accounts: 1,
        issues: 0,
        compliance: 95,
        lastScan: 'Oct 3, 2025',
        status: 'good',
        icon: '🔵',
        color: '#4285F4',
        expanded: false,
        details: {
          resources: 22,
          vulnerabilities: 1,
          cost: 456.80,
          region: 'us-central1, europe-west1'
        }
      }
    ];
  }


  loadChartData() {
    // Vulnerability data for bar chart
    this.vulnerabilityData = [
      { severity: 'High', count: 5, color: '#dc3545' },
      { severity: 'Medium', count: 12, color: '#ffc107' },
      { severity: 'Low', count: 20, color: '#28a745' }
    ];

    // Resource data for pie chart
    this.resourceData = [
      { status: 'Secure', count: 238, color: '#28a745' },
      { status: 'At Risk', count: 7, color: '#dc3545' }
    ];

    // Prepare chart data
    this.pieChartData = {
      labels: this.resourceData.map(d => d.status),
      datasets: [{
        data: this.resourceData.map(d => d.count),
        backgroundColor: this.resourceData.map(d => d.color),
        borderWidth: 2,
        borderColor: '#ffffff'
      }]
    };

    this.barChartData = {
      labels: this.vulnerabilityData.map(d => d.severity),
      datasets: [{
        label: 'Vulnerabilities',
        data: this.vulnerabilityData.map(d => d.count),
        backgroundColor: this.vulnerabilityData.map(d => d.color),
        borderColor: this.vulnerabilityData.map(d => d.color),
        borderWidth: 1
      }]
    };

  }

  toggleProviderExpansion(provider: CloudProvider) {
    provider.expanded = !provider.expanded;
  }

  getStatusIcon(status: string): string {
    switch (status) {
      case 'good': return '🟢';
      case 'medium': return '🟡';
      case 'critical': return '🔴';
      default: return '⚪';
    }
  }

  getStatusClass(status: string): string {
    switch (status) {
      case 'good': return 'status-good';
      case 'medium': return 'status-medium';
      case 'critical': return 'status-critical';
      default: return 'status-unknown';
    }
  }

  getTrendIcon(trend: string): string {
    switch (trend) {
      case 'up': return '↗️';
      case 'down': return '↘️';
      case 'stable': return '→';
      default: return '→';
    }
  }

  getTrendClass(trend: string): string {
    switch (trend) {
      case 'up': return 'trend-up';
      case 'down': return 'trend-down';
      case 'stable': return 'trend-stable';
      default: return 'trend-stable';
    }
  }

  getColorClass(color: string): string {
    return `color-${color}`;
  }

  refreshData() {
    // Simulate data refresh
    console.log('Refreshing security reports data...');
    this.loadSummaryCards();
    this.loadCloudProviders();
    this.loadChartData();
  }

  exportReport() {
    console.log('Exporting security report...');
    // Implement export functionality
  }


  getPieChartBackground(): string {
    if (this.resourceData.length < 2) return '';
    
    const total = this.resourceData[0].count + this.resourceData[1].count;
    const securePercentage = (this.resourceData[0].count / total) * 100;
    const secureDegrees = (securePercentage / 100) * 360;
    
    return `conic-gradient(
      #28a745 0deg ${secureDegrees}deg,
      #dc3545 ${secureDegrees}deg 360deg
    )`;
  }

  getMaxVulnerabilityCount(): number {
    return Math.max(...this.vulnerabilityData.map(d => d.count));
  }

  getBarHeight(item: VulnerabilityData): number {
    const maxCount = this.getMaxVulnerabilityCount();
    return (item.count / maxCount) * 100;
  }
}
