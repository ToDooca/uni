package xyz.todooc4.university.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.todooc4.university.entity.*;

public interface StudyProgramService {

	List<StudyProgram> findAll(Specification<StudyProgram> specification, Sort sort);

	StudyProgram save(StudyProgram studyProgram);

	StudyProgram update(StudyProgram studyProgram);

	StudyProgram findById(Integer programId);

	void deleteById(Integer programId);

	List<Subject> findAllSubjectsById(Integer programId);

	List<Subject> addSubjectsById(Integer programId, List<Subject> subjects);

	List<Subject> setSubjectsById(Integer programId, List<Subject> subjects);

	List<Subject> deleteSubjectsById(Integer programId, List<Subject> subjects);

}