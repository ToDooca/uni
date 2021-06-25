package xyz.todooc4.university.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import xyz.todooc4.university.entity.TestObligation;

@Repository
public interface TestObligationRepository extends JpaRepository<TestObligation, Integer>, JpaSpecificationExecutor<TestObligation> {

}