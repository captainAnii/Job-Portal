package com.geekster.Job.Portal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 1, max = 500)
    private String title;

    @NotBlank(message = "Description is required")
    @Size(min = 1, max = 500)
    private String description;

    @NotBlank(message = "Location is required")
    @Size(min = 1, max = 500)
    private String location;

    @NotNull(message = "Salary is required")
    @Min(value = 20000, message = "Salary must be a positive value")
    private Double salary;

    @NotBlank(message = "Company email is required")
    @Email(message = "Invalid email format")
    private String companyEmail;

    @NotBlank(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "Employer name is required")
    private String employerName;

    @NotNull(message = "Job type is required")
    @Enumerated(EnumType.STRING)
    private JobType jobType;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate appliedDate;
}
