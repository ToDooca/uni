package xyz.todooc4.university.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.repository.StudyProgramRepository;
import xyz.todooc4.university.service.StudyProgramService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class StudyProgramServiceImpl implements StudyProgramService {
	private final StudyProgramRepository studyProgramRepository;

	@Override
	public List<StudyProgram> findAll(Specification<StudyProgram> specification, Sort sort) {
		return studyProgramRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public StudyProgram findById(Integer programId) {
		return studyProgramRepository.findById(programId)
				.orElseThrow(() -> new NoSuchElementException("StudyProgramService.notFound"));
	}

	@Override
	public StudyProgram save(StudyProgram studyProgram) {
		return studyProgramRepository.save(studyProgram);
	}

	@Override
	public StudyProgram update(StudyProgram studyProgram) {
		return studyProgramRepository.save(studyProgram);
	}

	@Override
	public void deleteById(Integer programId) {
		studyProgramRepository.deleteById(programId);
	}

	@Override
	public List<Subject> findAllSubjectsById(Integer programId) {
		return findById(programId).getSubjects();
	}

	@Override
	public List<Subject> addSubjectsById(Integer programId, List<Subject> subjects) {
		StudyProgram studyProgram = findById(programId);
		studyProgram.getSubjects().addAll(subjects);
		return studyProgramRepository.save(studyProgram).getSubjects();
	}

	@Override
	public List<Subject> setSubjectsById(Integer programId, List<Subject> subjects) {
		StudyProgram studyProgram = findById(programId);
		studyProgram.setSubjects(subjects);
		return studyProgramRepository.save(studyProgram).getSubjects();
	}

	@Override
	public List<Subject> deleteSubjectsById(Integer programId, List<Subject> subjects) {
		StudyProgram studyProgram = findById(programId);
		studyProgram.getSubjects().removeAll(subjects);
		return studyProgramRepository.save(studyProgram).getSubjects();
	}


}