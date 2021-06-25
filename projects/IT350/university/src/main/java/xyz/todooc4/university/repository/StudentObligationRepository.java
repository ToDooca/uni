package xyz.todooc4.university.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import xyz.todooc4.university.entity.StudentObligation;

@Repository
public interface StudentObligationRepository extends JpaRepository<StudentObligation, Integer>, JpaSpecificationExecutor<StudentObligation> {

}