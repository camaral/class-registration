package camaral.github.io.classregistration.repository;

import camaral.github.io.classregistration.entity.CourseEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "courses", itemResourceRel = "course", collectionResourceRel = "courses")
public interface CourseRepository extends PagingAndSortingRepository<CourseEntity, Integer> {
    List<CourseEntity> findAllByStudentsNull();
}
