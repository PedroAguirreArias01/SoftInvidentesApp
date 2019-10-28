import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NormativaFormComponent } from './normativa-form.component';

describe('NormativaFormComponent', () => {
  let component: NormativaFormComponent;
  let fixture: ComponentFixture<NormativaFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NormativaFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NormativaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
