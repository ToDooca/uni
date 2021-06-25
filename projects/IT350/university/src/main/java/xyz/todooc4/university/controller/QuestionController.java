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
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {
	private final QuestionService questionService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllQuestions")
	public ResponseEntity<List<Question>> getAllQuestions(@RequestParam(name = "q", required = false) Specification<Question> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(questionService.findAll(specification, sort));
	}

	@GetMapping("/{questionId}")
	@ApiOperation(value = "", nickname = "getQuestionById")
	public ResponseEntity<Question> getQuestionById(@PathVariable Integer questionId) {
		return ResponseEntity.ok(questionService.findById(questionId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveQuestion")
	public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
		return ResponseEntity.status(HttpStatus.CREATED).body(questionService.save(question));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateQuestion")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
		return ResponseEntity.ok(questionService.update(question));
	}

	@DeleteMapping("/{questionId}")
	@ApiOperation(value = "", nickname = "deleteQuestionById")
	public void deleteQuestionById(@PathVariable Integer questionId) {
		questionService.deleteById(questionId);
	}

}

