package xyz.todooc4.university.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.todooc4.university.entity.*;

public interface StudentObligationService {

	List<StudentObligation> findAll(Specification<StudentObligation> specification, Sort sort);

	StudentObligation save(StudentObligation studentObligation);

	StudentObligation update(StudentObligation studentObligation);

	StudentObligation findById(Integer studentObligationId);

	void deleteById(Integer studentObligationId);

}