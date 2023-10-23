import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-KeycloakComponant',
  templateUrl: './KeycloakComponant.component.html',
  styleUrls: ['./KeycloakComponant.component.css']
})
export class KeycloakComponantComponent implements OnInit {

  constructor(private keycloakService: KeycloakService) { }

  ngOnInit() {
  }


  login() {
    this.keycloakService.login();
  }

  logout() {
    this.keycloakService.logout();
  }

}
