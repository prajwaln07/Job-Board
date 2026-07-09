package com.jobboard.demo.service;

import com.jobboard.demo.repository.JobRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jobboard.demo.model.Job;
import java.util.*;


@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> findAllJobs(){
        return jobRepository.findAll();
    }
    public Job createJob(Job job){
        return jobRepository.save(job);
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

}
