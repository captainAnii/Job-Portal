package com.geekster.Job.Portal.controller;

import com.geekster.Job.Portal.model.Job;
import com.geekster.Job.Portal.model.JobType;
import com.geekster.Job.Portal.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/V1/Job")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping(value = "/job")
    public ResponseEntity<Job> addJob(@Valid @RequestBody Job job) {
        Job savedJob = jobService.addJob(job);
        return ResponseEntity.ok(savedJob);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateJobType(@PathVariable Long id, @RequestParam JobType jobType) {
        jobService.updateJobType(id, jobType);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "Id/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "jobs")
    public ResponseEntity<List<Job>> fetchAllJob() {
        List<Job> jobs = jobService.fetchAllJob();
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Job>> getJobsByTitle(@PathVariable String title) {
        List<Job> jobs = jobService.getJobsByTitle(title);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/company/{companyName}")
    public ResponseEntity<List<Job>> getJobsByCompanyName(@PathVariable String companyName) {
        List<Job> jobs = jobService.getJobsByCompanyName(companyName);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
    @DeleteMapping("/location/{location}")
    public ResponseEntity<Void> deleteJobsByLocation(@PathVariable String location) {
        jobService.deleteJobsByLocation(location);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
