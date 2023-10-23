package com.example.forumManagement.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Discussion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDisc")
    Long idDisc;
    String msg;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime date ;

    @ManyToOne
    User user;

    @ManyToOne
    Project project;


}
