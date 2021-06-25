package xyz.todooc4.university.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import xyz.todooc4.university.entity.HomeworkObligation;

@Repository
public interface HomeworkObligationRepository extends JpaRepository<HomeworkObligation, Integer>, JpaSpecificationExecutor<HomeworkObligation> {

}