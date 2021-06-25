package xyz.todooc4.university.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import xyz.todooc4.university.entity.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer>, JpaSpecificationExecutor<Faculty> {

}