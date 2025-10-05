import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VulnerabilitiesComponent } from './vulnerabilities.component';

describe('VulnerabilitiesComponent', () => {
  let component: VulnerabilitiesComponent;
  let fixture: ComponentFixture<VulnerabilitiesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VulnerabilitiesComponent]
    });
    fixture = TestBed.createComponent(VulnerabilitiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
