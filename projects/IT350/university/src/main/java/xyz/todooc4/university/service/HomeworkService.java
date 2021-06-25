package xyz.todooc4.university.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.todooc4.university.entity.*;

public interface HomeworkService {

	List<Homework> findAll(Specification<Homework> specification, Sort sort);

	Homework save(Homework homework);

	Homework update(Homework homework);

	Homework findById(Integer homeworkId);

	void deleteById(Integer homeworkId);

}