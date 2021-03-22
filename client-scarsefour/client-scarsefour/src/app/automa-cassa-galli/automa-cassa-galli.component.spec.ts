import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutomaCassaGalliComponent } from './automa-cassa-galli.component';

describe('AutomaCassaGalliComponent', () => {
  let component: AutomaCassaGalliComponent;
  let fixture: ComponentFixture<AutomaCassaGalliComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AutomaCassaGalliComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AutomaCassaGalliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
