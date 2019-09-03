import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogindueComponent } from './logindue.component';

describe('LogindueComponent', () => {
  let component: LogindueComponent;
  let fixture: ComponentFixture<LogindueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogindueComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogindueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
