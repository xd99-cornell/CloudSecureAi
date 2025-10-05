import { Component, OnInit } from '@angular/core';

interface ChatMessage {
  id: string;
  type: 'user' | 'ai';
  content: string;
  timestamp: Date;
  isTyping?: boolean;
}

interface SuggestedQuestion {
  id: string;
  title: string;
  description: string;
  category: 'scan-help' | 'cloud-tips' | 'fix-alerts' | 'compliance' | 'security';
}

interface SecurityTip {
  id: string;
  title: string;
  description: string;
  priority: 'high' | 'medium' | 'low';
  category: string;
  actionText: string;
  isNew: boolean;
}

@Component({
  selector: 'app-ai-chat',
  templateUrl: './ai-chat.component.html',
  styleUrls: ['./ai-chat.component.css']
})
export class AiChatComponent implements OnInit {
  messages: ChatMessage[] = [];
  suggestedQuestions: SuggestedQuestion[] = [];
  securityTips: SecurityTip[] = [];
  currentMessage = '';
  isAiTyping = false;
  showSuggestions = true;

  constructor() {}

  ngOnInit() {
    this.loadSuggestedQuestions();
    this.loadSecurityTips();
    this.addWelcomeMessage();
  }

  addWelcomeMessage() {
    this.messages.push({
      id: '1',
      type: 'ai',
      content: "Hi! I'm your AI security assistant. I can help you with cloud security questions, explain alerts, and provide recommendations. What would you like to know?",
      timestamp: new Date()
    });
  }

  loadSuggestedQuestions() {
    this.suggestedQuestions = [
      {
        id: '1',
        title: 'Scan Help',
        description: 'How do I run a security scan?',
        category: 'scan-help'
      },
      {
        id: '2',
        title: 'Cloud Tips',
        description: 'Best practices for AWS security',
        category: 'cloud-tips'
      },
      {
        id: '3',
        title: 'Fix My Alerts',
        description: 'Help with security alerts',
        category: 'fix-alerts'
      },
      {
        id: '4',
        title: 'Compliance',
        description: 'GDPR and SOC2 guidance',
        category: 'compliance'
      },
      {
        id: '5',
        title: 'Security',
        description: 'General security questions',
        category: 'security'
      }
    ];
  }

  loadSecurityTips() {
    this.securityTips = [
      {
        id: '1',
        title: 'Enable Database Encryption',
        description: 'Your RDS instances are not encrypted. Enable encryption to protect sensitive data.',
        priority: 'high',
        category: 'Data Protection',
        actionText: 'Enable encryption now',
        isNew: true
      },
      {
        id: '2',
        title: 'Add MFA for Admin Users',
        description: 'Administrative accounts should have multi-factor authentication enabled.',
        priority: 'high',
        category: 'Access Control',
        actionText: 'Set up MFA',
        isNew: false
      },
      {
        id: '3',
        title: 'Review S3 Bucket Permissions',
        description: 'Some S3 buckets have overly permissive access policies.',
        priority: 'medium',
        category: 'Storage Security',
        actionText: 'Review permissions',
        isNew: false
      },
      {
        id: '4',
        title: 'Update Security Groups',
        description: 'Consider restricting SSH access to specific IP ranges.',
        priority: 'medium',
        category: 'Network Security',
        actionText: 'Update rules',
        isNew: false
      },
      {
        id: '5',
        title: 'Enable CloudTrail Logging',
        description: 'Enable comprehensive logging for better security monitoring.',
        priority: 'low',
        category: 'Monitoring',
        actionText: 'Enable logging',
        isNew: false
      }
    ];
  }

  sendMessage() {
    if (!this.currentMessage.trim()) return;

    // Add user message
    this.messages.push({
      id: Date.now().toString(),
      type: 'user',
      content: this.currentMessage,
      timestamp: new Date()
    });

    const userMessage = this.currentMessage;
    this.currentMessage = '';
    this.showSuggestions = false;

    // Simulate AI typing
    this.isAiTyping = true;
    setTimeout(() => {
      this.generateAiResponse(userMessage);
      this.isAiTyping = false;
    }, 1500);
  }

  generateAiResponse(userMessage: string) {
    let response = '';
    const message = userMessage.toLowerCase();

    if (message.includes('scan') || message.includes('security scan')) {
      response = "To run a security scan, go to the 'Vulnerability Scan' page and click 'Run Scan Now'. The scan will check your cloud resources for common security issues like open ports, weak passwords, and misconfigurations. Results will appear in the findings table with severity levels and fix recommendations.";
    } else if (message.includes('aws') || message.includes('s3') || message.includes('bucket')) {
      response = "For AWS S3 security, ensure your buckets have: 1) Proper access policies (avoid public read/write), 2) Server-side encryption enabled, 3) Versioning enabled for important data, 4) MFA delete protection, and 5) Lifecycle policies for cost optimization. Would you like specific guidance on any of these?";
    } else if (message.includes('compliance') || message.includes('gdpr') || message.includes('soc2')) {
      response = "Compliance requirements vary by framework. For GDPR: focus on data encryption, access controls, and data processing records. For SOC2: implement access controls, monitoring, and regular audits. Use our 'Compliance Rules' page to run automated checks against these standards.";
    } else if (message.includes('alert') || message.includes('warning') || message.includes('issue')) {
      response = "When you see security alerts, click the 'Explain with AI' icon next to any finding. I'll provide a plain-language explanation of the risk and step-by-step instructions to fix it. You can also use the 'Fix My Alerts' button above for general guidance.";
    } else if (message.includes('encryption') || message.includes('encrypt')) {
      response = "Encryption is crucial for data protection. Enable encryption at rest for databases, storage, and backups. Use encryption in transit for all communications. For AWS: enable RDS encryption, S3 server-side encryption, and use HTTPS/TLS for web traffic.";
    } else if (message.includes('password') || message.includes('auth') || message.includes('login')) {
      response = "Strong authentication is essential: 1) Use complex passwords (12+ characters, mixed case, numbers, symbols), 2) Enable MFA for all accounts, 3) Implement password policies, 4) Consider SSO for multiple services, 5) Regular password rotation for service accounts.";
    } else {
      response = "I can help with cloud security questions, compliance guidance, and explaining security alerts. Try asking about specific topics like 'AWS security best practices', 'How to fix compliance issues', or 'Explain this security alert'. What specific area would you like to know more about?";
    }

    this.messages.push({
      id: Date.now().toString(),
      type: 'ai',
      content: response,
      timestamp: new Date()
    });
  }

  askSuggestedQuestion(question: SuggestedQuestion) {
    this.currentMessage = question.description;
    this.sendMessage();
  }

  explainWithAI(tip: SecurityTip) {
    const explanation = `This is a ${tip.priority} priority security recommendation. ${tip.description} This falls under ${tip.category} and is important for maintaining a secure cloud environment. Would you like step-by-step instructions to implement this?`;
    
    this.messages.push({
      id: Date.now().toString(),
      type: 'ai',
      content: explanation,
      timestamp: new Date()
    });
  }

  getPriorityClass(priority: string): string {
    switch (priority) {
      case 'high': return 'priority-high';
      case 'medium': return 'priority-medium';
      case 'low': return 'priority-low';
      default: return '';
    }
  }

  getCategoryIcon(category: string): string {
    switch (category) {
      case 'Data Protection': return '🔒';
      case 'Access Control': return '👤';
      case 'Storage Security': return '💾';
      case 'Network Security': return '🌐';
      case 'Monitoring': return '📊';
      default: return '🔧';
    }
  }
}
