package camaral.github.io.classregistration.validation;

import camaral.github.io.classregistration.entity.CourseEntity;
import camaral.github.io.classregistration.entity.StudentEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Set;

@Component("beforeLinkSaveStudentValidator")
public class StudentEntityValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return StudentEntity.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentEntity student = (StudentEntity) target;
        Set<CourseEntity> courses = student.getCourses();
        if (courses != null) {
            courses.forEach(course -> {
                if (course.getStudents().size() > 1) {
                    errors.rejectValue("courses",
                            "course-is-full",
                            String.format("course %d is full and cannot accept new registrations", course.getId()));
                }
            });
        }
    }
}
