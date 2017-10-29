import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AttenddancereportComponent } from './attenddancereport.component';

describe('AttenddancereportComponent', () => {
  let component: AttenddancereportComponent;
  let fixture: ComponentFixture<AttenddancereportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AttenddancereportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AttenddancereportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
