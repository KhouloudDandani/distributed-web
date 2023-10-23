package com.example.forumManagement.service;


import com.example.forumManagement.entity.Discussion;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDiscussion {
    ResponseEntity<Discussion> createDiscussion(Discussion discussion, Long projectId );
    ResponseEntity<List<Discussion>> getAllByProjet(Long id);

}
