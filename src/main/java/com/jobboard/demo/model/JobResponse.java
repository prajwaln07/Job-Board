package com.jobboard.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobResponse {
    private Long id;
    private String title;
    private String location;
    private String salary;
    private String description;
}
