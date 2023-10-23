package com.example.forumManagement.repository;


import com.example.forumManagement.entity.Discussion;
import com.example.forumManagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscussionRepo extends JpaRepository<Discussion,Long> {
    List<Discussion> findAllByProjectOrderByDate(Project project);

}
