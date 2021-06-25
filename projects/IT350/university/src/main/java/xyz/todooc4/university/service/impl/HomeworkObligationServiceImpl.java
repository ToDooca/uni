package xyz.todooc4.university.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.repository.HomeworkObligationRepository;
import xyz.todooc4.university.service.HomeworkObligationService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class HomeworkObligationServiceImpl implements HomeworkObligationService {
	private final HomeworkObligationRepository homeworkObligationRepository;

	@Override
	public List<HomeworkObligation> findAll(Specification<HomeworkObligation> specification, Sort sort) {
		return homeworkObligationRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public HomeworkObligation findById(Integer homeworkObligationId) {
		return homeworkObligationRepository.findById(homeworkObligationId)
				.orElseThrow(() -> new NoSuchElementException("HomeworkObligationService.notFound"));
	}

	@Override
	public HomeworkObligation save(HomeworkObligation homeworkObligation) {
		return homeworkObligationRepository.save(homeworkObligation);
	}

	@Override
	public HomeworkObligation update(HomeworkObligation homeworkObligation) {
		return homeworkObligationRepository.save(homeworkObligation);
	}

	@Override
	public void deleteById(Integer homeworkObligationId) {
		homeworkObligationRepository.deleteById(homeworkObligationId);
	}


}