import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GymOwnerComponent } from './gym-owner.component';

describe('GymOwnerComponent', () => {
  let component: GymOwnerComponent;
  let fixture: ComponentFixture<GymOwnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GymOwnerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GymOwnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
