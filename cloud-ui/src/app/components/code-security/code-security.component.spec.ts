import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CodeSecurityComponent } from './code-security.component';

describe('CodeSecurityComponent', () => {
  let component: CodeSecurityComponent;
  let fixture: ComponentFixture<CodeSecurityComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CodeSecurityComponent]
    });
    fixture = TestBed.createComponent(CodeSecurityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
