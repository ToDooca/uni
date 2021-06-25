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
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswerController {
	private final AnswerService answerService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllAnswers")
	public ResponseEntity<List<Answer>> getAllAnswers(@RequestParam(name = "q", required = false) Specification<Answer> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(answerService.findAll(specification, sort));
	}

	@GetMapping("/{answerId}")
	@ApiOperation(value = "", nickname = "getAnswerById")
	public ResponseEntity<Answer> getAnswerById(@PathVariable Integer answerId) {
		return ResponseEntity.ok(answerService.findById(answerId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveAnswer")
	public ResponseEntity<Answer> saveAnswer(@RequestBody Answer answer) {
		return ResponseEntity.status(HttpStatus.CREATED).body(answerService.save(answer));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateAnswer")
	public ResponseEntity<Answer> updateAnswer(@RequestBody Answer answer) {
		return ResponseEntity.ok(answerService.update(answer));
	}

	@DeleteMapping("/{answerId}")
	@ApiOperation(value = "", nickname = "deleteAnswerById")
	public void deleteAnswerById(@PathVariable Integer answerId) {
		answerService.deleteById(answerId);
	}

}

