/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { KeycloakComponantComponent } from './KeycloakComponant.component';

describe('KeycloakComponantComponent', () => {
  let component: KeycloakComponantComponent;
  let fixture: ComponentFixture<KeycloakComponantComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KeycloakComponantComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KeycloakComponantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
