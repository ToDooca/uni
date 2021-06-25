package xyz.todooc4.university.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import xyz.todooc4.university.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>, JpaSpecificationExecutor<Question> {

}