package xyz.todooc4.university.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.repository.ProjectRepository;
import xyz.todooc4.university.service.ProjectService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProjectServiceImpl implements ProjectService {
	private final ProjectRepository projectRepository;

	@Override
	public List<Project> findAll(Specification<Project> specification, Sort sort) {
		return projectRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Project findById(Integer projectId) {
		return projectRepository.findById(projectId)
				.orElseThrow(() -> new NoSuchElementException("ProjectService.notFound"));
	}

	@Override
	public Project save(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project update(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public void deleteById(Integer projectId) {
		projectRepository.deleteById(projectId);
	}


}