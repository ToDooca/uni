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
@RequestMapping("/student-obligations")
@RequiredArgsConstructor
public class StudentObligationController {
	private final StudentObligationService studentObligationService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllStudentObligations")
	public ResponseEntity<List<StudentObligation>> getAllStudentObligations(@RequestParam(name = "q", required = false) Specification<StudentObligation> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(studentObligationService.findAll(specification, sort));
	}

	@GetMapping("/{studentObligationId}")
	@ApiOperation(value = "", nickname = "getStudentObligationById")
	public ResponseEntity<StudentObligation> getStudentObligationById(@PathVariable Integer studentObligationId) {
		return ResponseEntity.ok(studentObligationService.findById(studentObligationId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveStudentObligation")
	public ResponseEntity<StudentObligation> saveStudentObligation(@RequestBody StudentObligation studentObligation) {
		return ResponseEntity.status(HttpStatus.CREATED).body(studentObligationService.save(studentObligation));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateStudentObligation")
	public ResponseEntity<StudentObligation> updateStudentObligation(@RequestBody StudentObligation studentObligation) {
		return ResponseEntity.ok(studentObligationService.update(studentObligation));
	}

	@DeleteMapping("/{studentObligationId}")
	@ApiOperation(value = "", nickname = "deleteStudentObligationById")
	public void deleteStudentObligationById(@PathVariable Integer studentObligationId) {
		studentObligationService.deleteById(studentObligationId);
	}

}

