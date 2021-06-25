package xyz.todooc4.university.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.todooc4.university.entity.*;

public interface AnswerService {

	List<Answer> findAll(Specification<Answer> specification, Sort sort);

	Answer save(Answer answer);

	Answer update(Answer answer);

	Answer findById(Integer answerId);

	void deleteById(Integer answerId);

}