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
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {
	private final FacultyService facultyService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllFaculties")
	public ResponseEntity<List<Faculty>> getAllFaculties(@RequestParam(name = "q", required = false) Specification<Faculty> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(facultyService.findAll(specification, sort));
	}

	@GetMapping("/{facultyId}")
	@ApiOperation(value = "", nickname = "getFacultyById")
	public ResponseEntity<Faculty> getFacultyById(@PathVariable Integer facultyId) {
		return ResponseEntity.ok(facultyService.findById(facultyId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveFaculty")
	public ResponseEntity<Faculty> saveFaculty(@RequestBody Faculty faculty) {
		return ResponseEntity.status(HttpStatus.CREATED).body(facultyService.save(faculty));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateFaculty")
	public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
		return ResponseEntity.ok(facultyService.update(faculty));
	}

	@DeleteMapping("/{facultyId}")
	@ApiOperation(value = "", nickname = "deleteFacultyById")
	public void deleteFacultyById(@PathVariable Integer facultyId) {
		facultyService.deleteById(facultyId);
	}

}

