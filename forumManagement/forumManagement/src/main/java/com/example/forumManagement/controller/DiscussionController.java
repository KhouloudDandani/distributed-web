package com.example.forumManagement.controller;


import com.example.forumManagement.entity.Discussion;
import com.example.forumManagement.service.IDiscussion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Discussion")
@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 3600, allowCredentials="true")

public class DiscussionController {
    @Autowired
    IDiscussion iDiscussion;
    @PostMapping("/add/{projectId}")
    public ResponseEntity<Discussion> createDiscussion(@RequestBody Discussion discussion, @PathVariable Long projectId) {
        return  iDiscussion.createDiscussion(discussion,projectId);
    }

    @GetMapping("/getAll/{id}")
    public ResponseEntity<List<Discussion>> getAllByProjet(@PathVariable Long id){
        return iDiscussion.getAllByProjet(id);
    }


}