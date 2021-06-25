package xyz.todooc4.university.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.todooc4.university.entity.*;

public interface ProjectObligationService {

	List<ProjectObligation> findAll(Specification<ProjectObligation> specification, Sort sort);

	ProjectObligation save(ProjectObligation projectObligation);

	ProjectObligation update(ProjectObligation projectObligation);

	ProjectObligation findById(Integer projectObligationId);

	void deleteById(Integer projectObligationId);

}