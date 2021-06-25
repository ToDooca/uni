package xyz.todooc4.university.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.todooc4.university.entity.*;

public interface QuestionService {

	List<Question> findAll(Specification<Question> specification, Sort sort);

	Question save(Question question);

	Question update(Question question);

	Question findById(Integer questionId);

	void deleteById(Integer questionId);

}