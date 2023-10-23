package com.example.forumManagement.service;


import com.example.forumManagement.entity.Discussion;
import com.example.forumManagement.entity.Project;
import com.example.forumManagement.repository.DiscussionRepo;
import com.example.forumManagement.repository.ProjectRepository;
import com.example.forumManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DiscussionServices implements IDiscussion{

    @Autowired
    DiscussionRepo discussionRepo;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<Discussion> createDiscussion(Discussion discussion, Long projectId) {
        try{
            Project project= projectRepository.findById(projectId).orElse(null);
            discussion.setProject(project);
            discussion.setDate(LocalDateTime.now());
            discussionRepo.save(discussion);
            return new ResponseEntity<>(discussion, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }


    }

    @Override
    public ResponseEntity<List<Discussion>> getAllByProjet(Long id) {
        try{
            Project projet = projectRepository.findById(id).orElse(null);
            List<Discussion> discussions =discussionRepo.findAllByProjectOrderByDate(projet);
            return new ResponseEntity<>(discussions,HttpStatus.OK);

        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }




    }
}

