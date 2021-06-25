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
@RequestMapping("/test-obligations")
@RequiredArgsConstructor
public class TestObligationController {
	private final TestObligationService testObligationService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllTestObligations")
	public ResponseEntity<List<TestObligation>> getAllTestObligations(@RequestParam(name = "q", required = false) Specification<TestObligation> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(testObligationService.findAll(specification, sort));
	}

	@GetMapping("/{testObligationId}")
	@ApiOperation(value = "", nickname = "getTestObligationById")
	public ResponseEntity<TestObligation> getTestObligationById(@PathVariable Integer testObligationId) {
		return ResponseEntity.ok(testObligationService.findById(testObligationId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveTestObligation")
	public ResponseEntity<TestObligation> saveTestObligation(@RequestBody TestObligation testObligation) {
		return ResponseEntity.status(HttpStatus.CREATED).body(testObligationService.save(testObligation));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateTestObligation")
	public ResponseEntity<TestObligation> updateTestObligation(@RequestBody TestObligation testObligation) {
		return ResponseEntity.ok(testObligationService.update(testObligation));
	}

	@DeleteMapping("/{testObligationId}")
	@ApiOperation(value = "", nickname = "deleteTestObligationById")
	public void deleteTestObligationById(@PathVariable Integer testObligationId) {
		testObligationService.deleteById(testObligationId);
	}

}

