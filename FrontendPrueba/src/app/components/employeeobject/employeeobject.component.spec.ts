import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeobjectComponent } from './employeeobject.component';

describe('EmployeeobjectComponent', () => {
  let component: EmployeeobjectComponent;
  let fixture: ComponentFixture<EmployeeobjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeobjectComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeobjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
