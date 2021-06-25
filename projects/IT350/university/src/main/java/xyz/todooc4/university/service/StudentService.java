package xyz.todooc4.university.service;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import xyz.todooc4.university.entity.*;

public interface StudentService {

	List<Student> findAll(Specification<Student> specification, Sort sort);

	Student save(Student student);

	Student update(Student student);

	Student findById(Integer studentId);

	void deleteById(Integer studentId);

	List<Subject> findAllSubjectsById(Integer studentId);

	List<Subject> addSubjectsById(Integer studentId, List<Subject> subjects);

	List<Subject> setSubjectsById(Integer studentId, List<Subject> subjects);

	List<Subject> deleteSubjectsById(Integer studentId, List<Subject> subjects);

}