package xyz.todooc4.university.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.repository.ProfessorRepository;
import xyz.todooc4.university.service.ProfessorService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProfessorServiceImpl implements ProfessorService {
	private final ProfessorRepository professorRepository;

	@Override
	public List<Professor> findAll(Specification<Professor> specification, Sort sort) {
		return professorRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Professor findById(Integer professorId) {
		return professorRepository.findById(professorId)
				.orElseThrow(() -> new NoSuchElementException("ProfessorService.notFound"));
	}

	@Override
	public Professor save(Professor professor) {
		return professorRepository.save(professor);
	}

	@Override
	public Professor update(Professor professor) {
		return professorRepository.save(professor);
	}

	@Override
	public void deleteById(Integer professorId) {
		professorRepository.deleteById(professorId);
	}


}