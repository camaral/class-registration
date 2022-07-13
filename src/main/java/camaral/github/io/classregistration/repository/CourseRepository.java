package camaral.github.io.classregistration.repository;

import camaral.github.io.classregistration.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "courses", itemResourceRel = "course", collectionResourceRel = "courses")
public interface CourseRepository extends CrudRepository<CourseEntity, Integer> {
}
