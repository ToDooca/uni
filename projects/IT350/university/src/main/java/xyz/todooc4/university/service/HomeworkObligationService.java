package xyz.todooc4.university.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.todooc4.university.entity.*;

public interface HomeworkObligationService {

	List<HomeworkObligation> findAll(Specification<HomeworkObligation> specification, Sort sort);

	HomeworkObligation save(HomeworkObligation homeworkObligation);

	HomeworkObligation update(HomeworkObligation homeworkObligation);

	HomeworkObligation findById(Integer homeworkObligationId);

	void deleteById(Integer homeworkObligationId);

}