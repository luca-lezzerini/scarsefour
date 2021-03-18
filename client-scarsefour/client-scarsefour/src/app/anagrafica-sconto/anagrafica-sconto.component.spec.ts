import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnagraficaScontoComponent } from './anagrafica-sconto.component';

describe('AnagraficaScontoComponent', () => {
  let component: AnagraficaScontoComponent;
  let fixture: ComponentFixture<AnagraficaScontoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnagraficaScontoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnagraficaScontoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
