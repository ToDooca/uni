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
@RequestMapping("/homeworks")
@RequiredArgsConstructor
public class HomeworkController {
	private final HomeworkService homeworkService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllHomeworks")
	public ResponseEntity<List<Homework>> getAllHomeworks(@RequestParam(name = "q", required = false) Specification<Homework> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(homeworkService.findAll(specification, sort));
	}

	@GetMapping("/{homeworkId}")
	@ApiOperation(value = "", nickname = "getHomeworkById")
	public ResponseEntity<Homework> getHomeworkById(@PathVariable Integer homeworkId) {
		return ResponseEntity.ok(homeworkService.findById(homeworkId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveHomework")
	public ResponseEntity<Homework> saveHomework(@RequestBody Homework homework) {
		return ResponseEntity.status(HttpStatus.CREATED).body(homeworkService.save(homework));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateHomework")
	public ResponseEntity<Homework> updateHomework(@RequestBody Homework homework) {
		return ResponseEntity.ok(homeworkService.update(homework));
	}

	@DeleteMapping("/{homeworkId}")
	@ApiOperation(value = "", nickname = "deleteHomeworkById")
	public void deleteHomeworkById(@PathVariable Integer homeworkId) {
		homeworkService.deleteById(homeworkId);
	}

}

