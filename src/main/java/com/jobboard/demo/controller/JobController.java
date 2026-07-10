package com.jobboard.demo.controller;

import com.jobboard.demo.model.JobResponse;
import com.jobboard.demo.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jobboard.demo.model.Job;
import java.util.*;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("getAllJobs")
    public List<JobResponse> getAllJobs(){
       return jobService.findAllJobs();
    }

    @PostMapping("/createJob")
    public Job createJob(@Valid @RequestBody Job job){
        return jobService.createJob(job);
    }

    @GetMapping("/{id}")
    public Job getJob(@PathVariable Long id){
        return jobService.getJobById(id);
    }

    @PostMapping("/update/{id}")
    public Job updateJob(@PathVariable Long id,@RequestBody Job job){
        return jobService.updateJob(id,job);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
    }


}
