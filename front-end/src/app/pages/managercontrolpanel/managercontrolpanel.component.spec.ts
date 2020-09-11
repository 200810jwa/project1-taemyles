import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagercontrolpanelComponent } from './managercontrolpanel.component';

describe('ManagercontrolpanelComponent', () => {
  let component: ManagercontrolpanelComponent;
  let fixture: ComponentFixture<ManagercontrolpanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagercontrolpanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagercontrolpanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
