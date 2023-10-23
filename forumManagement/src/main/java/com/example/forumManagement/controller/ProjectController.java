package com.example.forumManagement.controller;


import com.example.forumManagement.entity.Project;
import com.example.forumManagement.repository.ProjectRepository;
import com.example.forumManagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class ProjectController {

    @Autowired
    private ProjectService projectService;



//    @PostMapping({"/addNewProject/{id}"})
//    public ResponseEntity<Project> addNewProject(@RequestBody Project project, @PathVariable String id) {
//        return projectService.addNewProject(project, id);
//    }
//    @PostMapping("/addNewProject")
//    public ResponseEntity<Project> addNewProject(@RequestBody Project project) {
//        String id = "sana"; // Set the user ID to 'sana' in the backend code
//
//        return projectService.addNewProject(project, id);
//    }

    @PostMapping({"/addNewProject"})
    public Project addNewProject(@RequestBody Project project) {
        return projectService.addNewProject(project);
    }


    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/projects/{projectId}")
    public Project getProjectDetail(@PathVariable Long projectId) {
        return projectService.getProjectDetail(projectId);
    }

    @DeleteMapping("/project/{id}")
    public void deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
    }

    @PutMapping("/updateProject/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project updatedProject) {
        try {
            Project project = projectService.updateProject(id, updatedProject);
            return new ResponseEntity<>(project, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
