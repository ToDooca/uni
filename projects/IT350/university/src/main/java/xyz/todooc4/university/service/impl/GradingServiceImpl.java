package xyz.todooc4.university.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.repository.GradingRepository;
import xyz.todooc4.university.service.GradingService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class GradingServiceImpl implements GradingService {
	private final GradingRepository gradingRepository;

	@Override
	public List<Grading> findAll(Specification<Grading> specification, Sort sort) {
		return gradingRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Grading findById(Integer gradingId) {
		return gradingRepository.findById(gradingId)
				.orElseThrow(() -> new NoSuchElementException("GradingService.notFound"));
	}

	@Override
	public Grading save(Grading grading) {
		return gradingRepository.save(grading);
	}

	@Override
	public Grading update(Grading grading) {
		return gradingRepository.save(grading);
	}

	@Override
	public void deleteById(Integer gradingId) {
		gradingRepository.deleteById(gradingId);
	}


}