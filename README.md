# Job-Portal

The Job Search Portal is a web application built using Spring Boot that allows users to search and view job listings. It provides basic CRUD operations for managing jobs and includes custom finder methods for querying jobs based on different criteria.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- Postman (for testing API endpoints)

## Setup and Installation

1. Clone the repository:

git clone https://github.com/your-username/job-search-portal.git

arduino
Copy code

2. Import the project into your favorite IDE (e.g., IntelliJ, Eclipse).

3. Build and run the application.

4. Open Postman or any other HTTP client to test the API endpoints.

## API Endpoints

### Create a Job

- Endpoint: POST /jobs
- Request Body:
json
{
 "title": "Software Engineer",
 "description": "Develop software applications",
 "location": "New York",
 "salary": 80000,
 "companyName": "ABC Corp",
 "employerName": "John Doe",
 "jobType": "IT",
 "appliedDate": "2023-05-01"
}
  Response: The created job object with a generated ID.
- Get All Jobs
  Endpoint: GET /jobs
  Response: An array of job objects.
- Get Jobs by Location
  Endpoint: GET /jobs/byLocation?location={location}
  Response: An array of job objects that match the specified location.
- Get Jobs by Company Name
  Endpoint: GET /jobs/byCompanyName?companyName={companyName}
  Response: An array of job objects that match the specified company name.
- Update a Job
  Endpoint: PUT /jobs/{id}
  Request Body: Same as the create job endpoint.
  Response: The updated job object.
- Delete a Job
  Endpoint: DELETE /jobs/{id}
  Response: A success message indicating the deletion status.
### Custom Finder Methods
The project includes custom finder methods to search for jobs based on specific criteria, such as location and company name. These methods are implemented using Spring Data JPA query generation based on method names.

### Contributing
Contributions are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue or submit a pull request.

### License
This project is licensed under the MIT License.
