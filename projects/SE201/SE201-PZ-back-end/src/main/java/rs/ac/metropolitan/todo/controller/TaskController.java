package rs.ac.metropolitan.todo.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.todo.entity.*;
import rs.ac.metropolitan.todo.service.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
	private final TaskService taskService;

	@GetMapping
	public ResponseEntity<List<Task>> getAll() {
		return ResponseEntity.ok(taskService.findAll());
	}

	@GetMapping("/{taskId}")
	public ResponseEntity<Task> getById(@PathVariable Integer taskId) {
		return ResponseEntity.ok(taskService.findById(taskId));
	}

	@PostMapping
	public ResponseEntity<Task> save(@RequestBody Task task) {
		return ResponseEntity.status(201).body(taskService.save(task));
	}

	@PutMapping
	public ResponseEntity<Task> update(@RequestBody Task task) {
		return ResponseEntity.ok(taskService.update(task));
	}

	@DeleteMapping("/{taskId}")
	public void deleteById(@PathVariable Integer taskId) {
		taskService.deleteById(taskId);
	}

}

