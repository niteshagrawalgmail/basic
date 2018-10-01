import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EspensesListComponent } from './espenses-list.component';

describe('EspensesListComponent', () => {
  let component: EspensesListComponent;
  let fixture: ComponentFixture<EspensesListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EspensesListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EspensesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
