package rs.ac.metropolitan.todo.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.metropolitan.todo.entity.*;
import rs.ac.metropolitan.todo.service.*;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {
	private final TagService tagService;

	@GetMapping
	public ResponseEntity<List<Tag>> getAll() {
		return ResponseEntity.ok(tagService.findAll());
	}

	@GetMapping("/{tagId}")
	public ResponseEntity<Tag> getById(@PathVariable Integer tagId) {
		return ResponseEntity.ok(tagService.findById(tagId));
	}

	@PostMapping
	public ResponseEntity<Tag> save(@RequestBody Tag tag) {
		return ResponseEntity.status(201).body(tagService.save(tag));
	}

	@PutMapping
	public ResponseEntity<Tag> update(@RequestBody Tag tag) {
		return ResponseEntity.ok(tagService.update(tag));
	}

	@DeleteMapping("/{tagId}")
	public void deleteById(@PathVariable Integer tagId) {
		tagService.deleteById(tagId);
	}

}

