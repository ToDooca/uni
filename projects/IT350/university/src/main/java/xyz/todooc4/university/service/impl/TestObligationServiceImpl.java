package xyz.todooc4.university.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.repository.TestObligationRepository;
import xyz.todooc4.university.service.TestObligationService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class TestObligationServiceImpl implements TestObligationService {
	private final TestObligationRepository testObligationRepository;

	@Override
	public List<TestObligation> findAll(Specification<TestObligation> specification, Sort sort) {
		return testObligationRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public TestObligation findById(Integer testObligationId) {
		return testObligationRepository.findById(testObligationId)
				.orElseThrow(() -> new NoSuchElementException("TestObligationService.notFound"));
	}

	@Override
	public TestObligation save(TestObligation testObligation) {
		return testObligationRepository.save(testObligation);
	}

	@Override
	public TestObligation update(TestObligation testObligation) {
		return testObligationRepository.save(testObligation);
	}

	@Override
	public void deleteById(Integer testObligationId) {
		testObligationRepository.deleteById(testObligationId);
	}


}