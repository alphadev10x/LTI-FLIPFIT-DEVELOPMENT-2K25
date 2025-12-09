import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GymAdminComponent } from './gym-admin.component';

describe('GymAdminComponent', () => {
  let component: GymAdminComponent;
  let fixture: ComponentFixture<GymAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GymAdminComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GymAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
