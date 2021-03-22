import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardCassaHisComponent } from './dashboard-cassa-his.component';

describe('DashboardCassaHisComponent', () => {
  let component: DashboardCassaHisComponent;
  let fixture: ComponentFixture<DashboardCassaHisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardCassaHisComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardCassaHisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
