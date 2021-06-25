package xyz.todooc4.university.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.repository.TestRepository;
import xyz.todooc4.university.service.TestService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class TestServiceImpl implements TestService {
	private final TestRepository testRepository;

	@Override
	public List<Test> findAll(Specification<Test> specification, Sort sort) {
		return testRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Test findById(Integer testId) {
		return testRepository.findById(testId)
				.orElseThrow(() -> new NoSuchElementException("TestService.notFound"));
	}

	@Override
	public Test save(Test test) {
		return testRepository.save(test);
	}

	@Override
	public Test update(Test test) {
		return testRepository.save(test);
	}

	@Override
	public void deleteById(Integer testId) {
		testRepository.deleteById(testId);
	}


}