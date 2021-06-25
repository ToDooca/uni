package xyz.todooc4.university.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.todooc4.university.entity.*;

public interface ProjectService {

	List<Project> findAll(Specification<Project> specification, Sort sort);

	Project save(Project project);

	Project update(Project project);

	Project findById(Integer projectId);

	void deleteById(Integer projectId);

}