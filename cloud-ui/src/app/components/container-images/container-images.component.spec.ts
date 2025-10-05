import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContainerImagesComponent } from './container-images.component';

describe('ContainerImagesComponent', () => {
  let component: ContainerImagesComponent;
  let fixture: ComponentFixture<ContainerImagesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ContainerImagesComponent]
    });
    fixture = TestBed.createComponent(ContainerImagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
