import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CloudAccountsComponent } from './cloud-accounts.component';

describe('CloudAccountsComponent', () => {
  let component: CloudAccountsComponent;
  let fixture: ComponentFixture<CloudAccountsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CloudAccountsComponent]
    });
    fixture = TestBed.createComponent(CloudAccountsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
