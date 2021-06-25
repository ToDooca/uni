package xyz.todooc4.university.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.repository.HomeworkRepository;
import xyz.todooc4.university.service.HomeworkService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class HomeworkServiceImpl implements HomeworkService {
	private final HomeworkRepository homeworkRepository;

	@Override
	public List<Homework> findAll(Specification<Homework> specification, Sort sort) {
		return homeworkRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Homework findById(Integer homeworkId) {
		return homeworkRepository.findById(homeworkId)
				.orElseThrow(() -> new NoSuchElementException("HomeworkService.notFound"));
	}

	@Override
	public Homework save(Homework homework) {
		return homeworkRepository.save(homework);
	}

	@Override
	public Homework update(Homework homework) {
		return homeworkRepository.save(homework);
	}

	@Override
	public void deleteById(Integer homeworkId) {
		homeworkRepository.deleteById(homeworkId);
	}


}