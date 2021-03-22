import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardCassaIllComponent } from './dashboard-cassa-ill.component';

describe('DashboardCassaIllComponent', () => {
  let component: DashboardCassaIllComponent;
  let fixture: ComponentFixture<DashboardCassaIllComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardCassaIllComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardCassaIllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
