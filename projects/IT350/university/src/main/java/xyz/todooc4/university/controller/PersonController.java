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
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
	private final PersonService personService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllPersons")
	public ResponseEntity<List<Person>> getAllPersons(@RequestParam(name = "q", required = false) Specification<Person> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(personService.findAll(specification, sort));
	}

	@GetMapping("/{personId}")
	@ApiOperation(value = "", nickname = "getPersonById")
	public ResponseEntity<Person> getPersonById(@PathVariable Integer personId) {
		return ResponseEntity.ok(personService.findById(personId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "savePerson")
	public ResponseEntity<Person> savePerson(@RequestBody Person person) {
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(person));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updatePerson")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
		return ResponseEntity.ok(personService.update(person));
	}

	@DeleteMapping("/{personId}")
	@ApiOperation(value = "", nickname = "deletePersonById")
	public void deletePersonById(@PathVariable Integer personId) {
		personService.deleteById(personId);
	}

}

