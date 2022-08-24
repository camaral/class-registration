# Class Registration

I usually would write backend APIs using RestContollers, Services and Repositories, documenting the endpoints with
OpenAPI. But I've been planning to try Spring Data REST for some time, and used some spare time to do it.

## Building and running the application

Use `docker-compose.yml` as you usually do. Running `class-registration` will start the `mysql` instance and the
service. The service will be available under http://localhost:8080/.

Optionally one can run the aplication locally. It requires an instalation of JDK 17. Maven wrapper is bundled.
Run `./mvnw --version` (
Windows users: use `mvnw.cmd` instead) to check that everything is set up correctly. Then run `./mvnw spring-boot:run`
to start the application, which will also be available under http://localhost:8080/.

## REST API examples

The REST APIs follow the HATEOS format from Spring Data REST. Request examples are under `src/test/resources`. If you
use IntelliJ, you can execute the files directly from the IDE. Otherwise, you can use the `curl` commands inside thoses
files.

The following API are available.

1. Students CRUD
2. Courses CRUD
3. Students registration to courses
4. View all relationships between students and courses(no direct endpoint; see Improvement session)
5. Filter all students with a specific course
6. Filter all courses for a specific student
7. Filter all courses without any students
8. Filter all students without any courses


