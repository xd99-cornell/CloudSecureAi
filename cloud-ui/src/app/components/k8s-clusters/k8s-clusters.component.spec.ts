import { ComponentFixture, TestBed } from '@angular/core/testing';

import { K8sClustersComponent } from './k8s-clusters.component';

describe('K8sClustersComponent', () => {
  let component: K8sClustersComponent;
  let fixture: ComponentFixture<K8sClustersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [K8sClustersComponent]
    });
    fixture = TestBed.createComponent(K8sClustersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
