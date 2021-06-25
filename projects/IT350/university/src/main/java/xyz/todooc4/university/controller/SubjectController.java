package xyz.todooc4.university.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.service.*;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {
	private final SubjectService subjectService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllSubjects")
	public ResponseEntity<List<Subject>> getAllSubjects(@RequestParam(name = "q", required = false) Specification<Subject> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(subjectService.findAll(specification, sort));
	}

	@GetMapping("/{subjectId}")
	@ApiOperation(value = "", nickname = "getSubjectById")
	public ResponseEntity<Subject> getSubjectById(@PathVariable Integer subjectId) {
		return ResponseEntity.ok(subjectService.findById(subjectId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveSubject")
	public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject) {
		return ResponseEntity.status(HttpStatus.CREATED).body(subjectService.save(subject));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateSubject")
	public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject) {
		return ResponseEntity.ok(subjectService.update(subject));
	}

	@DeleteMapping("/{subjectId}")
	@ApiOperation(value = "", nickname = "deleteSubjectById")
	public void deleteSubjectById(@PathVariable Integer subjectId) {
		subjectService.deleteById(subjectId);
	}

	@GetMapping("/{subjectId}/study-programs")
	@ApiOperation(value = "", nickname = "getSubjectStudyPrograms")
	public ResponseEntity<List<StudyProgram>> getSubjectStudyPrograms(@PathVariable Integer subjectId) {
		return ResponseEntity.ok(subjectService.findAllStudyProgramsById(subjectId));
	}

	@PostMapping("/{subjectId}/study-programs")
	@ApiOperation(value = "", nickname = "setSubjectStudyPrograms")
	public ResponseEntity<List<StudyProgram>> setSubjectStudyPrograms(@PathVariable Integer subjectId, @RequestBody List<StudyProgram> studyPrograms) {
		return ResponseEntity.ok(subjectService.setStudyProgramsById(subjectId, studyPrograms));
	}

	@PutMapping("/{subjectId}/study-programs")
	@ApiOperation(value = "", nickname = "addSubjectStudyPrograms")
	public ResponseEntity<List<StudyProgram>> addSubjectStudyPrograms(@PathVariable Integer subjectId, @RequestBody List<StudyProgram> studyPrograms) {
		return ResponseEntity.ok(subjectService.addStudyProgramsById(subjectId, studyPrograms));
	}

	@DeleteMapping("/{subjectId}/study-programs")
	@ApiOperation(value = "", nickname = "deleteSubjectStudyPrograms")
	public ResponseEntity<List<StudyProgram>> deleteSubjectStudyPrograms(@PathVariable Integer subjectId, @RequestBody List<StudyProgram> studyPrograms) {
		return ResponseEntity.ok(subjectService.deleteStudyProgramsById(subjectId, studyPrograms));
	}

	@GetMapping("/{subjectId}/students")
	@ApiOperation(value = "", nickname = "getSubjectStudents")
	public ResponseEntity<List<Student>> getSubjectStudents(@PathVariable Integer subjectId) {
		return ResponseEntity.ok(subjectService.findAllStudentsById(subjectId));
	}

	@PostMapping("/{subjectId}/students")
	@ApiOperation(value = "", nickname = "setSubjectStudents")
	public ResponseEntity<List<Student>> setSubjectStudents(@PathVariable Integer subjectId, @RequestBody List<Student> students) {
		return ResponseEntity.ok(subjectService.setStudentsById(subjectId, students));
	}

	@PutMapping("/{subjectId}/students")
	@ApiOperation(value = "", nickname = "addSubjectStudents")
	public ResponseEntity<List<Student>> addSubjectStudents(@PathVariable Integer subjectId, @RequestBody List<Student> students) {
		return ResponseEntity.ok(subjectService.addStudentsById(subjectId, students));
	}

	@DeleteMapping("/{subjectId}/students")
	@ApiOperation(value = "", nickname = "deleteSubjectStudents")
	public ResponseEntity<List<Student>> deleteSubjectStudents(@PathVariable Integer subjectId, @RequestBody List<Student> students) {
		return ResponseEntity.ok(subjectService.deleteStudentsById(subjectId, students));
	}

}

