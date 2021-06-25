package xyz.todooc4.university.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.todooc4.university.entity.*;

public interface SubjectService {

	List<Subject> findAll(Specification<Subject> specification, Sort sort);

	Subject save(Subject subject);

	Subject update(Subject subject);

	Subject findById(Integer subjectId);

	void deleteById(Integer subjectId);

	List<StudyProgram> findAllStudyProgramsById(Integer subjectId);

	List<StudyProgram> addStudyProgramsById(Integer subjectId, List<StudyProgram> studyPrograms);

	List<StudyProgram> setStudyProgramsById(Integer subjectId, List<StudyProgram> studyPrograms);

	List<StudyProgram> deleteStudyProgramsById(Integer subjectId, List<StudyProgram> studyPrograms);

	List<Student> findAllStudentsById(Integer subjectId);

	List<Student> addStudentsById(Integer subjectId, List<Student> students);

	List<Student> setStudentsById(Integer subjectId, List<Student> students);

	List<Student> deleteStudentsById(Integer subjectId, List<Student> students);

}