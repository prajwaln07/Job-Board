package com.jobboard.demo.service;

import com.jobboard.demo.model.JobResponse;
import com.jobboard.demo.repository.JobRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jobboard.demo.model.Job;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<JobResponse> findAllJobs(){
        return jobRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
    public JobResponse createJob(Job job){
        return toResponse(jobRepository.save(job));
    }

    public Job getJobById(Long id){
        return jobRepository.findById(id).orElseThrow(()->
            new RuntimeException("Job not found with id : " + id)
        );

    }

    public Job updateJob(Long id,@NonNull Job updatedJob){
        Job existing = getJobById(id);
        existing.setTitle(updatedJob.getTitle());
        existing.setTitle(updatedJob.getTitle());
        existing.setDescription(updatedJob.getDescription());
        existing.setLocation(updatedJob.getLocation());
        existing.setSalary(updatedJob.getSalary());
        return jobRepository.save(existing);
    }

    public void deleteJob(Long id){
        jobRepository.deleteById(id);
    }

    private JobResponse toResponse(Job job) {
        return new JobResponse(
                job.getId(),
                job.getTitle(),
                job.getLocation(),
                job.getSalary(),
                job.getDescription()
        );
    }

}
