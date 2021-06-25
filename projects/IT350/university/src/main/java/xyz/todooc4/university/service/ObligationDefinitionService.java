package xyz.todooc4.university.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.todooc4.university.entity.*;

public interface ObligationDefinitionService {

	List<ObligationDefinition> findAll(Specification<ObligationDefinition> specification, Sort sort);

	ObligationDefinition save(ObligationDefinition obligationDefinition);

	ObligationDefinition update(ObligationDefinition obligationDefinition);

	ObligationDefinition findById(Integer obligationDefinitionId);

	void deleteById(Integer obligationDefinitionId);

}