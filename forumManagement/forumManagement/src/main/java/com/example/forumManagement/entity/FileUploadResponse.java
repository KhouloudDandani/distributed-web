package com.example.forumManagement.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class FileUploadResponse {

    private String fileName;
    private String downloadUrl;
    private long size;


}
