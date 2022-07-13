-- liquibase formatted sql
-- changeset camaral:TASK-1
-- comment: create initial tables

CREATE TABLE students
(
    id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) DEFAULT NULL
);

CREATE TABLE courses
(
    id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) DEFAULT NULL
);

CREATE TABLE students_courses
(
    student_id INT,
    course_id  INT,
    PRIMARY KEY (student_id, course_id),
    INDEX idx_students_courses_student (student_id),
    INDEX idx_students_courses_courses (course_id),
    CONSTRAINT fk_students_courses_students
        FOREIGN KEY (student_id) REFERENCES students (id),
    CONSTRAINT fk_students_courses_courses
        FOREIGN KEY (course_id) REFERENCES courses (id)
);
