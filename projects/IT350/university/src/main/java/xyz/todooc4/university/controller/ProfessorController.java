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
@RequestMapping("/professors")
@RequiredArgsConstructor
public class ProfessorController {
	private final ProfessorService professorService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllProfessors")
	public ResponseEntity<List<Professor>> getAllProfessors(@RequestParam(name = "q", required = false) Specification<Professor> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(professorService.findAll(specification, sort));
	}

	@GetMapping("/{professorId}")
	@ApiOperation(value = "", nickname = "getProfessorById")
	public ResponseEntity<Professor> getProfessorById(@PathVariable Integer professorId) {
		return ResponseEntity.ok(professorService.findById(professorId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveProfessor")
	public ResponseEntity<Professor> saveProfessor(@RequestBody Professor professor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(professorService.save(professor));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateProfessor")
	public ResponseEntity<Professor> updateProfessor(@RequestBody Professor professor) {
		return ResponseEntity.ok(professorService.update(professor));
	}

	@DeleteMapping("/{professorId}")
	@ApiOperation(value = "", nickname = "deleteProfessorById")
	public void deleteProfessorById(@PathVariable Integer professorId) {
		professorService.deleteById(professorId);
	}

}

