package xyz.todooc4.university.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import xyz.todooc4.university.entity.Grading;

@Repository
public interface GradingRepository extends JpaRepository<Grading, Integer>, JpaSpecificationExecutor<Grading> {

}