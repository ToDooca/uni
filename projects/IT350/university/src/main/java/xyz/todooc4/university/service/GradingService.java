package xyz.todooc4.university.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.todooc4.university.entity.*;

public interface GradingService {

	List<Grading> findAll(Specification<Grading> specification, Sort sort);

	Grading save(Grading grading);

	Grading update(Grading grading);

	Grading findById(Integer gradingId);

	void deleteById(Integer gradingId);

}