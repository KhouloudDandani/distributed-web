package com.example.guestnestf.IServices;

import com.example.guestnestf.entities.User;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IuserService {



    User  addUser(User userDTO);
    void addUser2(User userDTO) ;
 //  User mapToUser(UserRepresentation userRepresentation);
 List<UserRepresentation> getUser(String userName) ;
    UsersResource getInstance();


}