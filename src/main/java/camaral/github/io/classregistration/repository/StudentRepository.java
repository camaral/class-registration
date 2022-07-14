package camaral.github.io.classregistration.repository;

import camaral.github.io.classregistration.entity.StudentEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "students", itemResourceRel = "student", collectionResourceRel = "students")
public interface StudentRepository extends PagingAndSortingRepository<StudentEntity, Integer> {
    List<StudentEntity> findAllByCoursesNull();
}
