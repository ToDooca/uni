package xyz.todooc4.university.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import xyz.todooc4.university.entity.Homework;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Integer>, JpaSpecificationExecutor<Homework> {

}