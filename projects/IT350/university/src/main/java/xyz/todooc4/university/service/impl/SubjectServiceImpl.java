package xyz.todooc4.university.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.repository.SubjectRepository;
import xyz.todooc4.university.service.SubjectService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class SubjectServiceImpl implements SubjectService {
	private final SubjectRepository subjectRepository;

	@Override
	public List<Subject> findAll(Specification<Subject> specification, Sort sort) {
		return subjectRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Subject findById(Integer subjectId) {
		return subjectRepository.findById(subjectId)
				.orElseThrow(() -> new NoSuchElementException("SubjectService.notFound"));
	}

	@Override
	public Subject save(Subject subject) {
		return subjectRepository.save(subject);
	}

	@Override
	public Subject update(Subject subject) {
		return subjectRepository.save(subject);
	}

	@Override
	public void deleteById(Integer subjectId) {
		subjectRepository.deleteById(subjectId);
	}

	@Override
	public List<StudyProgram> findAllStudyProgramsById(Integer subjectId) {
		return findById(subjectId).getStudyPrograms();
	}

	@Override
	public List<StudyProgram> addStudyProgramsById(Integer subjectId, List<StudyProgram> studyPrograms) {
		Subject subject = findById(subjectId);
		subject.getStudyPrograms().addAll(studyPrograms);
		return subjectRepository.save(subject).getStudyPrograms();
	}

	@Override
	public List<StudyProgram> setStudyProgramsById(Integer subjectId, List<StudyProgram> studyPrograms) {
		Subject subject = findById(subjectId);
		subject.setStudyPrograms(studyPrograms);
		return subjectRepository.save(subject).getStudyPrograms();
	}

	@Override
	public List<StudyProgram> deleteStudyProgramsById(Integer subjectId, List<StudyProgram> studyPrograms) {
		Subject subject = findById(subjectId);
		subject.getStudyPrograms().removeAll(studyPrograms);
		return subjectRepository.save(subject).getStudyPrograms();
	}

	@Override
	public List<Student> findAllStudentsById(Integer subjectId) {
		return findById(subjectId).getStudents();
	}

	@Override
	public List<Student> addStudentsById(Integer subjectId, List<Student> students) {
		Subject subject = findById(subjectId);
		subject.getStudents().addAll(students);
		return subjectRepository.save(subject).getStudents();
	}

	@Override
	public List<Student> setStudentsById(Integer subjectId, List<Student> students) {
		Subject subject = findById(subjectId);
		subject.setStudents(students);
		return subjectRepository.save(subject).getStudents();
	}

	@Override
	public List<Student> deleteStudentsById(Integer subjectId, List<Student> students) {
		Subject subject = findById(subjectId);
		subject.getStudents().removeAll(students);
		return subjectRepository.save(subject).getStudents();
	}


}