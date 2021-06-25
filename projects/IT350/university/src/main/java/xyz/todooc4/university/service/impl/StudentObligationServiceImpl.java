package xyz.todooc4.university.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.repository.StudentObligationRepository;
import xyz.todooc4.university.service.StudentObligationService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class StudentObligationServiceImpl implements StudentObligationService {
	private final StudentObligationRepository studentObligationRepository;

	@Override
	public List<StudentObligation> findAll(Specification<StudentObligation> specification, Sort sort) {
		return studentObligationRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public StudentObligation findById(Integer studentObligationId) {
		return studentObligationRepository.findById(studentObligationId)
				.orElseThrow(() -> new NoSuchElementException("StudentObligationService.notFound"));
	}

	@Override
	public StudentObligation save(StudentObligation studentObligation) {
		return studentObligationRepository.save(studentObligation);
	}

	@Override
	public StudentObligation update(StudentObligation studentObligation) {
		return studentObligationRepository.save(studentObligation);
	}

	@Override
	public void deleteById(Integer studentObligationId) {
		studentObligationRepository.deleteById(studentObligationId);
	}


}