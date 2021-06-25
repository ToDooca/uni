package xyz.todooc4.university.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.repository.FacultyRepository;
import xyz.todooc4.university.service.FacultyService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class FacultyServiceImpl implements FacultyService {
	private final FacultyRepository facultyRepository;

	@Override
	public List<Faculty> findAll(Specification<Faculty> specification, Sort sort) {
		return facultyRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Faculty findById(Integer facultyId) {
		return facultyRepository.findById(facultyId)
				.orElseThrow(() -> new NoSuchElementException("FacultyService.notFound"));
	}

	@Override
	public Faculty save(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	public Faculty update(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	public void deleteById(Integer facultyId) {
		facultyRepository.deleteById(facultyId);
	}


}