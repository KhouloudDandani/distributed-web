package com.example.guestnestf.Services;


import com.example.guestnestf.IServices.IuserService;
import com.example.guestnestf.Repositories.UserRepository;
import com.example.guestnestf.configuration.Credentials;
import com.example.guestnestf.configuration.KeycloakProvider;
import com.example.guestnestf.entities.User;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
public class UserService implements IuserService {

 KeycloakRestTemplate keycloakRestTemplate;
 @Autowired
 UserRepository userRepository;
 Keycloak keycloak;
 @Autowired
 private BCryptPasswordEncoder passwordEncoder;

 private KeycloakSecurityContext keycloakSecurityContext;


 public User addUser(User user) {

  User savedUser = userRepository.save(user);


  return savedUser;
 }


 public void addUser2(User userDTO){
  CredentialRepresentation credential = Credentials
          .createPasswordCredentials(userDTO.getPassword());
  UserRepresentation user = new UserRepresentation();
  user.setUsername(userDTO.getUsername());
  user.setFirstName(userDTO.getFirstname());
  user.setLastName(userDTO.getLastname());
  user.setEmail(userDTO.getEmail());

  user.setCredentials(Collections.singletonList(credential));
  user.setEnabled(true);

  UsersResource instance = getInstance();
  instance.create(user);


  User dbUser = new User();
  dbUser.setFirstname(userDTO.getFirstname());
  dbUser.setLastname(userDTO.getLastname());
  dbUser.setEmail(userDTO.getEmail());
  dbUser.setPassword(userDTO.getPassword());
  dbUser.setUsername(userDTO.getUsername());


  userRepository.save(dbUser);
 }

 public List<UserRepresentation> getUser(String userName){
  UsersResource usersResource = getInstance();
  List<UserRepresentation> user = usersResource.search(userName, true);
  return user;

 }

 public UsersResource getInstance(){
  return KeycloakProvider.getInstance().realm(KeycloakProvider.realm).users();
 }


 }






