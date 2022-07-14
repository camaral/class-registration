# Class Registration

I usually would write backend APIs using RestContollers, Services and Repositories, documenting the endpoints with
OpenAPI. But I've been planning to try Spring Data REST for some time, and I thought this Take Home Assignment would be
a good opportunity to do it.

## Improvements

I unfortunally cannot spend too much time in this take home assignement, so I left some things to be done.

- Block concurrent updates of courses, to avoid course having more than 50 students. I think this may be possible using
  optimist locking; if not, then a trigger checking the size may be required.
- Increase test coverage. I didn't create any unit tests because I wrote almost no code(just configs). In this case I
  would need to write e2e test, using TestContainers.
- Add pagination. Some pagination is already done, but not all. It should be straight forward to do it with Spring Data
  REST.
- View all relationships between students and courses requires navigating the responses. An improvement would be to
  create [projections](https://docs.spring.io/spring-data/rest/docs/3.7.x/reference/html/#projections-excerpts.projections)
  .

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


