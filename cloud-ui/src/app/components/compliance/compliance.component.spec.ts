import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComplianceComponent } from './compliance.component';

describe('ComplianceComponent', () => {
  let component: ComplianceComponent;
  let fixture: ComponentFixture<ComplianceComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ComplianceComponent]
    });
    fixture = TestBed.createComponent(ComplianceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
