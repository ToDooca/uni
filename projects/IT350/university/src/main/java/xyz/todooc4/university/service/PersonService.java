package xyz.todooc4.university.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.todooc4.university.entity.*;

public interface PersonService {

	List<Person> findAll(Specification<Person> specification, Sort sort);

	Person save(Person person);

	Person update(Person person);

	Person findById(Integer personId);

	void deleteById(Integer personId);

}