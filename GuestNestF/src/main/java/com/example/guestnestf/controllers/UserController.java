package com.example.guestnestf.controllers;


import com.example.guestnestf.IServices.IuserService;
import com.example.guestnestf.Repositories.UserRepository;
import com.example.guestnestf.entities.User;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    IuserService service;
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;




    @PostMapping("/keycloakUseradd")
    public String addUser(@RequestBody User userDTO){
        service.addUser2(userDTO);
        return "User Added Successfully.";
    }

    @PostMapping("/normaluseradd")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createUser(@RequestBody User user, KeycloakAuthenticationToken auth) {
        try {
            KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) auth.getPrincipal();
            KeycloakSecurityContext context = principal.getKeycloakSecurityContext();
            boolean hasStudentRole = context.getToken().getRealmAccess().isUserInRole("user");
            Set<String> roles = context.getToken().getRealmAccess().getRoles();
            System.out.println("User roles: " + roles);
            if (hasStudentRole) {
                User createdUser = service.addUser(user);
                return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (Exception e) {
            // Handle exceptions, log the error, and return an appropriate response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    }









