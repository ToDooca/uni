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
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
	private final ProjectService projectService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllProjects")
	public ResponseEntity<List<Project>> getAllProjects(@RequestParam(name = "q", required = false) Specification<Project> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(projectService.findAll(specification, sort));
	}

	@GetMapping("/{projectId}")
	@ApiOperation(value = "", nickname = "getProjectById")
	public ResponseEntity<Project> getProjectById(@PathVariable Integer projectId) {
		return ResponseEntity.ok(projectService.findById(projectId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveProject")
	public ResponseEntity<Project> saveProject(@RequestBody Project project) {
		return ResponseEntity.status(HttpStatus.CREATED).body(projectService.save(project));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateProject")
	public ResponseEntity<Project> updateProject(@RequestBody Project project) {
		return ResponseEntity.ok(projectService.update(project));
	}

	@DeleteMapping("/{projectId}")
	@ApiOperation(value = "", nickname = "deleteProjectById")
	public void deleteProjectById(@PathVariable Integer projectId) {
		projectService.deleteById(projectId);
	}

}

