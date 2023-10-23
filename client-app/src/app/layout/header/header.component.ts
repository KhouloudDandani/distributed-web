import { Component ,OnInit  } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent  {




  constructor(private readonly keycloak: KeycloakService) {}


  init() {
    return this.keycloak.init();
}

login() {
    this.keycloak.login();
}

logout() {
    this.keycloak.logout();
}

getToken() {
    return this.keycloak.getKeycloakInstance().token;
}

isLoggedIn() {
    return this.keycloak.getKeycloakInstance().authenticated;
}

getUsername() {
  const idTokenParsed = this.keycloak.getKeycloakInstance().idTokenParsed;
  return idTokenParsed ? idTokenParsed['preferred_username'] || 'Guest' : 'Guest';
}

}
