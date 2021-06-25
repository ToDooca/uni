package xyz.todooc4.university.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import xyz.todooc4.university.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer>, JpaSpecificationExecutor<Test> {

}