import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CassaMacComponent } from './cassa-mac.component';

describe('CassaMacComponent', () => {
  let component: CassaMacComponent;
  let fixture: ComponentFixture<CassaMacComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CassaMacComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CassaMacComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
