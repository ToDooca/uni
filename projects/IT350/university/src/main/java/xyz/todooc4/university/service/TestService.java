package xyz.todooc4.university.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.todooc4.university.entity.*;

public interface TestService {

	List<Test> findAll(Specification<Test> specification, Sort sort);

	Test save(Test test);

	Test update(Test test);

	Test findById(Integer testId);

	void deleteById(Integer testId);

}