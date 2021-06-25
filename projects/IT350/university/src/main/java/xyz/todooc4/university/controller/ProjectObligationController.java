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
@RequestMapping("/project-obligations")
@RequiredArgsConstructor
public class ProjectObligationController {
	private final ProjectObligationService projectObligationService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllProjectObligations")
	public ResponseEntity<List<ProjectObligation>> getAllProjectObligations(@RequestParam(name = "q", required = false) Specification<ProjectObligation> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(projectObligationService.findAll(specification, sort));
	}

	@GetMapping("/{projectObligationId}")
	@ApiOperation(value = "", nickname = "getProjectObligationById")
	public ResponseEntity<ProjectObligation> getProjectObligationById(@PathVariable Integer projectObligationId) {
		return ResponseEntity.ok(projectObligationService.findById(projectObligationId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveProjectObligation")
	public ResponseEntity<ProjectObligation> saveProjectObligation(@RequestBody ProjectObligation projectObligation) {
		return ResponseEntity.status(HttpStatus.CREATED).body(projectObligationService.save(projectObligation));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateProjectObligation")
	public ResponseEntity<ProjectObligation> updateProjectObligation(@RequestBody ProjectObligation projectObligation) {
		return ResponseEntity.ok(projectObligationService.update(projectObligation));
	}

	@DeleteMapping("/{projectObligationId}")
	@ApiOperation(value = "", nickname = "deleteProjectObligationById")
	public void deleteProjectObligationById(@PathVariable Integer projectObligationId) {
		projectObligationService.deleteById(projectObligationId);
	}

}

