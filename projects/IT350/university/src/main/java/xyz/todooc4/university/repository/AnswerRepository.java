package xyz.todooc4.university.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import xyz.todooc4.university.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>, JpaSpecificationExecutor<Answer> {

}