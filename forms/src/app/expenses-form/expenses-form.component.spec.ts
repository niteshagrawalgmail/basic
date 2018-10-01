import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpensesFormComponent } from './expenses-form.component';

describe('ExpensesFormComponent', () => {
  let component: ExpensesFormComponent;
  let fixture: ComponentFixture<ExpensesFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExpensesFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExpensesFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
