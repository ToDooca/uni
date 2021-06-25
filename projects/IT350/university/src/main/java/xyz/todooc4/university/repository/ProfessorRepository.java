package xyz.todooc4.university.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import xyz.todooc4.university.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>, JpaSpecificationExecutor<Professor> {

}