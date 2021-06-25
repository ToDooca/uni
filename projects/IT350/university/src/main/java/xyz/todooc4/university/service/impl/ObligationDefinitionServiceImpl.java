package xyz.todooc4.university.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.repository.ObligationDefinitionRepository;
import xyz.todooc4.university.service.ObligationDefinitionService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ObligationDefinitionServiceImpl implements ObligationDefinitionService {
	private final ObligationDefinitionRepository obligationDefinitionRepository;

	@Override
	public List<ObligationDefinition> findAll(Specification<ObligationDefinition> specification, Sort sort) {
		return obligationDefinitionRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public ObligationDefinition findById(Integer obligationDefinitionId) {
		return obligationDefinitionRepository.findById(obligationDefinitionId)
				.orElseThrow(() -> new NoSuchElementException("ObligationDefinitionService.notFound"));
	}

	@Override
	public ObligationDefinition save(ObligationDefinition obligationDefinition) {
		return obligationDefinitionRepository.save(obligationDefinition);
	}

	@Override
	public ObligationDefinition update(ObligationDefinition obligationDefinition) {
		return obligationDefinitionRepository.save(obligationDefinition);
	}

	@Override
	public void deleteById(Integer obligationDefinitionId) {
		obligationDefinitionRepository.deleteById(obligationDefinitionId);
	}


}