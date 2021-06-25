package xyz.todooc4.university.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.repository.ProjectObligationRepository;
import xyz.todooc4.university.service.ProjectObligationService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProjectObligationServiceImpl implements ProjectObligationService {
	private final ProjectObligationRepository projectObligationRepository;

	@Override
	public List<ProjectObligation> findAll(Specification<ProjectObligation> specification, Sort sort) {
		return projectObligationRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public ProjectObligation findById(Integer projectObligationId) {
		return projectObligationRepository.findById(projectObligationId)
				.orElseThrow(() -> new NoSuchElementException("ProjectObligationService.notFound"));
	}

	@Override
	public ProjectObligation save(ProjectObligation projectObligation) {
		return projectObligationRepository.save(projectObligation);
	}

	@Override
	public ProjectObligation update(ProjectObligation projectObligation) {
		return projectObligationRepository.save(projectObligation);
	}

	@Override
	public void deleteById(Integer projectObligationId) {
		projectObligationRepository.deleteById(projectObligationId);
	}


}