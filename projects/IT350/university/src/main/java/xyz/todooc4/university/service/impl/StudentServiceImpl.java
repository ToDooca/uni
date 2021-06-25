package xyz.todooc4.university.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.repository.StudentRepository;
import xyz.todooc4.university.service.StudentService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class StudentServiceImpl implements StudentService {
	private final StudentRepository studentRepository;

	@Override
	public List<Student> findAll(Specification<Student> specification, Sort sort) {
		return studentRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Student findById(Integer studentId) {
		return studentRepository.findById(studentId)
				.orElseThrow(() -> new NoSuchElementException("StudentService.notFound"));
	}

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student update(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteById(Integer studentId) {
		studentRepository.deleteById(studentId);
	}

	@Override
	public List<Subject> findAllSubjectsById(Integer studentId) {
		return findById(studentId).getSubjects();
	}

	@Override
	public List<Subject> addSubjectsById(Integer studentId, List<Subject> subjects) {
		Student student = findById(studentId);
		student.getSubjects().addAll(subjects);
		return studentRepository.save(student).getSubjects();
	}

	@Override
	public List<Subject> setSubjectsById(Integer studentId, List<Subject> subjects) {
		Student student = findById(studentId);
		student.setSubjects(subjects);
		return studentRepository.save(student).getSubjects();
	}

	@Override
	public List<Subject> deleteSubjectsById(Integer studentId, List<Subject> subjects) {
		Student student = findById(studentId);
		student.getSubjects().removeAll(subjects);
		return studentRepository.save(student).getSubjects();
	}


}