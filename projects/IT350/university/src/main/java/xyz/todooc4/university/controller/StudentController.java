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
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
	private final StudentService studentService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents(@RequestParam(name = "q", required = false) Specification<Student> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(studentService.findAll(specification, sort));
	}

	@GetMapping("/{studentId}")
	@ApiOperation(value = "", nickname = "getStudentById")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer studentId) {
		return ResponseEntity.ok(studentService.findById(studentId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateStudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		return ResponseEntity.ok(studentService.update(student));
	}

	@DeleteMapping("/{studentId}")
	@ApiOperation(value = "", nickname = "deleteStudentById")
	public void deleteStudentById(@PathVariable Integer studentId) {
		studentService.deleteById(studentId);
	}

	@GetMapping("/{studentId}/subjects")
	@ApiOperation(value = "", nickname = "getStudentSubjects")
	public ResponseEntity<List<Subject>> getStudentSubjects(@PathVariable Integer studentId) {
		return ResponseEntity.ok(studentService.findAllSubjectsById(studentId));
	}

	@PostMapping("/{studentId}/subjects")
	@ApiOperation(value = "", nickname = "setStudentSubjects")
	public ResponseEntity<List<Subject>> setStudentSubjects(@PathVariable Integer studentId, @RequestBody List<Subject> subjects) {
		return ResponseEntity.ok(studentService.setSubjectsById(studentId, subjects));
	}

	@PutMapping("/{studentId}/subjects")
	@ApiOperation(value = "", nickname = "addStudentSubjects")
	public ResponseEntity<List<Subject>> addStudentSubjects(@PathVariable Integer studentId, @RequestBody List<Subject> subjects) {
		return ResponseEntity.ok(studentService.addSubjectsById(studentId, subjects));
	}

	@DeleteMapping("/{studentId}/subjects")
	@ApiOperation(value = "", nickname = "deleteStudentSubjects")
	public ResponseEntity<List<Subject>> deleteStudentSubjects(@PathVariable Integer studentId, @RequestBody List<Subject> subjects) {
		return ResponseEntity.ok(studentService.deleteSubjectsById(studentId, subjects));
	}

}

