package xyz.todooc4.university.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.todooc4.university.entity.*;

public interface TestObligationService {

	List<TestObligation> findAll(Specification<TestObligation> specification, Sort sort);

	TestObligation save(TestObligation testObligation);

	TestObligation update(TestObligation testObligation);

	TestObligation findById(Integer testObligationId);

	void deleteById(Integer testObligationId);

}