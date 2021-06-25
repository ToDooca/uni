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
@RequestMapping("/gradings")
@RequiredArgsConstructor
public class GradingController {
	private final GradingService gradingService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllGradings")
	public ResponseEntity<List<Grading>> getAllGradings(@RequestParam(name = "q", required = false) Specification<Grading> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(gradingService.findAll(specification, sort));
	}

	@GetMapping("/{gradingId}")
	@ApiOperation(value = "", nickname = "getGradingById")
	public ResponseEntity<Grading> getGradingById(@PathVariable Integer gradingId) {
		return ResponseEntity.ok(gradingService.findById(gradingId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveGrading")
	public ResponseEntity<Grading> saveGrading(@RequestBody Grading grading) {
		return ResponseEntity.status(HttpStatus.CREATED).body(gradingService.save(grading));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateGrading")
	public ResponseEntity<Grading> updateGrading(@RequestBody Grading grading) {
		return ResponseEntity.ok(gradingService.update(grading));
	}

	@DeleteMapping("/{gradingId}")
	@ApiOperation(value = "", nickname = "deleteGradingById")
	public void deleteGradingById(@PathVariable Integer gradingId) {
		gradingService.deleteById(gradingId);
	}

}

