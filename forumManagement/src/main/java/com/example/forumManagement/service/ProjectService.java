package com.example.forumManagement.service;

import com.example.forumManagement.entity.Discussion;
import com.example.forumManagement.entity.Project;
import com.example.forumManagement.entity.User;
import com.example.forumManagement.repository.DiscussionRepo;
import com.example.forumManagement.repository.ProjectRepository;
import com.example.forumManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;


    @Autowired
    DiscussionRepo discussionRepo;

    @Autowired
    UserRepository userRepository;

    public Project addNewProject (Project project){
        return projectRepository.save(project);

    }


    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }




    public Project updateProject(Long id, Project updatedProject)  {
        // Find the existing project
        Project existingProject = projectRepository.findById(id).orElseThrow(
                null
        );

        // Update the fields
        existingProject.setProjectName(updatedProject.getProjectName());
        existingProject.setProjectDescription(updatedProject.getProjectDescription());
        existingProject.setSponsor(updatedProject.getSponsor());
        existingProject.setDomain(updatedProject.getDomain());
        existingProject.setNature(updatedProject.getNature());
        existingProject.setStartDate(updatedProject.getStartDate());
        existingProject.setEndDate(updatedProject.getEndDate());

        // Save and return the updated project
        return projectRepository.save(existingProject);
    }


    public void deleteProject(Long id){
        projectRepository.deleteById(id);
    }

    public Project getProjectDetail(Long projectId) {
        return projectRepository.findByProjectId(projectId);
    }



}
