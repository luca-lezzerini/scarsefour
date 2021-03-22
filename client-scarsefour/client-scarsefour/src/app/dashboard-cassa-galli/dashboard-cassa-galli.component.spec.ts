import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardCassaGalliComponent } from './dashboard-cassa-galli.component';

describe('DashboardCassaGalliComponent', () => {
  let component: DashboardCassaGalliComponent;
  let fixture: ComponentFixture<DashboardCassaGalliComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardCassaGalliComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardCassaGalliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
