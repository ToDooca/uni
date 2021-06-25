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
@RequestMapping("/homework-obligations")
@RequiredArgsConstructor
public class HomeworkObligationController {
	private final HomeworkObligationService homeworkObligationService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllHomeworkObligations")
	public ResponseEntity<List<HomeworkObligation>> getAllHomeworkObligations(@RequestParam(name = "q", required = false) Specification<HomeworkObligation> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(homeworkObligationService.findAll(specification, sort));
	}

	@GetMapping("/{homeworkObligationId}")
	@ApiOperation(value = "", nickname = "getHomeworkObligationById")
	public ResponseEntity<HomeworkObligation> getHomeworkObligationById(@PathVariable Integer homeworkObligationId) {
		return ResponseEntity.ok(homeworkObligationService.findById(homeworkObligationId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveHomeworkObligation")
	public ResponseEntity<HomeworkObligation> saveHomeworkObligation(@RequestBody HomeworkObligation homeworkObligation) {
		return ResponseEntity.status(HttpStatus.CREATED).body(homeworkObligationService.save(homeworkObligation));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateHomeworkObligation")
	public ResponseEntity<HomeworkObligation> updateHomeworkObligation(@RequestBody HomeworkObligation homeworkObligation) {
		return ResponseEntity.ok(homeworkObligationService.update(homeworkObligation));
	}

	@DeleteMapping("/{homeworkObligationId}")
	@ApiOperation(value = "", nickname = "deleteHomeworkObligationById")
	public void deleteHomeworkObligationById(@PathVariable Integer homeworkObligationId) {
		homeworkObligationService.deleteById(homeworkObligationId);
	}

}

