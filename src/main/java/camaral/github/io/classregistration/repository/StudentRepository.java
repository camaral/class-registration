package camaral.github.io.classregistration.repository;

import camaral.github.io.classregistration.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "students", itemResourceRel = "student", collectionResourceRel = "students")
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
}
