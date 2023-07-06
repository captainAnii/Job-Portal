package com.geekster.Job.Portal.repository;

import com.geekster.Job.Portal.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface iJobRepository extends JpaRepository<Job, Long> {
    // Custom finder method to get jobs by title
    List<Job> findByTitle(String title);

    // Custom finder method to get jobs by company name
    List<Job> findByCompanyName(String companyName);

    // Custom query to delete jobs by location
    @Query("DELETE FROM Job j WHERE j.location = :location")
    @Modifying
    void deleteByLocation(@Param("location") String location);
}
