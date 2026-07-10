package com.jobboard.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobRequest {
    private String title;
    private String description;
    private String location;
    private String salary;
}