package com.geekster.Job.Portal.service;

import com.geekster.Job.Portal.model.Job;
import com.geekster.Job.Portal.model.JobType;
import com.geekster.Job.Portal.repository.iJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class JobService {

    @Autowired
    iJobRepository jobRepository;

    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    public void updateJobType(Long id, JobType jobType) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if(optionalJob.isPresent()){
            Job job = optionalJob.get();
            job.setJobType(jobType);
            jobRepository.save(job);
        }
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    public List<Job> fetchAllJob() {
        return jobRepository.findAll();
    }
    public List<Job> getJobsByTitle(String title) {
        return jobRepository.findByTitle(title);
    }
    public List<Job> getJobsByCompanyName(String companyName) {
        return jobRepository.findByCompanyName(companyName);
    }
    public void deleteJobsByLocation(String location) {
        jobRepository.deleteByLocation(location);
    }
}
