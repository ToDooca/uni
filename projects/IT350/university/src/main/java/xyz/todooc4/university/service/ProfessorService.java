package xyz.todooc4.university.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.todooc4.university.entity.*;

public interface ProfessorService {

	List<Professor> findAll(Specification<Professor> specification, Sort sort);

	Professor save(Professor professor);

	Professor update(Professor professor);

	Professor findById(Integer professorId);

	void deleteById(Integer professorId);

}