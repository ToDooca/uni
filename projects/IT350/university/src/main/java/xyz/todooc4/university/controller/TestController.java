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
@RequestMapping("/tests")
@RequiredArgsConstructor
public class TestController {
	private final TestService testService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllTests")
	public ResponseEntity<List<Test>> getAllTests(@RequestParam(name = "q", required = false) Specification<Test> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(testService.findAll(specification, sort));
	}

	@GetMapping("/{testId}")
	@ApiOperation(value = "", nickname = "getTestById")
	public ResponseEntity<Test> getTestById(@PathVariable Integer testId) {
		return ResponseEntity.ok(testService.findById(testId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveTest")
	public ResponseEntity<Test> saveTest(@RequestBody Test test) {
		return ResponseEntity.status(HttpStatus.CREATED).body(testService.save(test));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateTest")
	public ResponseEntity<Test> updateTest(@RequestBody Test test) {
		return ResponseEntity.ok(testService.update(test));
	}

	@DeleteMapping("/{testId}")
	@ApiOperation(value = "", nickname = "deleteTestById")
	public void deleteTestById(@PathVariable Integer testId) {
		testService.deleteById(testId);
	}

}

