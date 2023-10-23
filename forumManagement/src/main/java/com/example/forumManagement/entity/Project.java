package com.example.forumManagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    private String projectName;
    private String projectDescription;
    private String sponsor;
    private String domain;
    private String nature;
    @Temporal(TemporalType.DATE)

    private Date startDate;
    @Temporal(TemporalType.DATE)

    private Date endDate;

    @ManyToOne
    private User user;


}



