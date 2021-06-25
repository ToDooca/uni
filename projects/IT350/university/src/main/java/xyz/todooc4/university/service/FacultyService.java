package xyz.todooc4.university.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.todooc4.university.entity.*;

public interface FacultyService {

	List<Faculty> findAll(Specification<Faculty> specification, Sort sort);

	Faculty save(Faculty faculty);

	Faculty update(Faculty faculty);

	Faculty findById(Integer facultyId);

	void deleteById(Integer facultyId);

}