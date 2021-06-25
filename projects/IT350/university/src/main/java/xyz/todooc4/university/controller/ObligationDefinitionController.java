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
@RequestMapping("/obligation-definitions")
@RequiredArgsConstructor
public class ObligationDefinitionController {
	private final ObligationDefinitionService obligationDefinitionService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllObligationDefinitions")
	public ResponseEntity<List<ObligationDefinition>> getAllObligationDefinitions(@RequestParam(name = "q", required = false) Specification<ObligationDefinition> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(obligationDefinitionService.findAll(specification, sort));
	}

	@GetMapping("/{obligationDefinitionId}")
	@ApiOperation(value = "", nickname = "getObligationDefinitionById")
	public ResponseEntity<ObligationDefinition> getObligationDefinitionById(@PathVariable Integer obligationDefinitionId) {
		return ResponseEntity.ok(obligationDefinitionService.findById(obligationDefinitionId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveObligationDefinition")
	public ResponseEntity<ObligationDefinition> saveObligationDefinition(@RequestBody ObligationDefinition obligationDefinition) {
		return ResponseEntity.status(HttpStatus.CREATED).body(obligationDefinitionService.save(obligationDefinition));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateObligationDefinition")
	public ResponseEntity<ObligationDefinition> updateObligationDefinition(@RequestBody ObligationDefinition obligationDefinition) {
		return ResponseEntity.ok(obligationDefinitionService.update(obligationDefinition));
	}

	@DeleteMapping("/{obligationDefinitionId}")
	@ApiOperation(value = "", nickname = "deleteObligationDefinitionById")
	public void deleteObligationDefinitionById(@PathVariable Integer obligationDefinitionId) {
		obligationDefinitionService.deleteById(obligationDefinitionId);
	}

}

