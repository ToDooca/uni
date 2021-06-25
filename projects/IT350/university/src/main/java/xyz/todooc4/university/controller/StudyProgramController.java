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
@RequestMapping("/study-programs")
@RequiredArgsConstructor
public class StudyProgramController {
	private final StudyProgramService studyProgramService;

	@GetMapping
	@ApiOperation(value = "", nickname = "getAllStudyPrograms")
	public ResponseEntity<List<StudyProgram>> getAllStudyPrograms(@RequestParam(name = "q", required = false) Specification<StudyProgram> specification, @RequestParam(name = "sort", required = false) Sort sort) {
		return ResponseEntity.ok(studyProgramService.findAll(specification, sort));
	}

	@GetMapping("/{programId}")
	@ApiOperation(value = "", nickname = "getStudyProgramById")
	public ResponseEntity<StudyProgram> getStudyProgramById(@PathVariable Integer programId) {
		return ResponseEntity.ok(studyProgramService.findById(programId));
	}

	@PostMapping
	@ApiOperation(value = "", nickname = "saveStudyProgram")
	public ResponseEntity<StudyProgram> saveStudyProgram(@RequestBody StudyProgram studyProgram) {
		return ResponseEntity.status(HttpStatus.CREATED).body(studyProgramService.save(studyProgram));
	}

	@PutMapping
	@ApiOperation(value = "", nickname = "updateStudyProgram")
	public ResponseEntity<StudyProgram> updateStudyProgram(@RequestBody StudyProgram studyProgram) {
		return ResponseEntity.ok(studyProgramService.update(studyProgram));
	}

	@DeleteMapping("/{programId}")
	@ApiOperation(value = "", nickname = "deleteStudyProgramById")
	public void deleteStudyProgramById(@PathVariable Integer programId) {
		studyProgramService.deleteById(programId);
	}

	@GetMapping("/{programId}/subjects")
	@ApiOperation(value = "", nickname = "getStudyProgramSubjects")
	public ResponseEntity<List<Subject>> getStudyProgramSubjects(@PathVariable Integer programId) {
		return ResponseEntity.ok(studyProgramService.findAllSubjectsById(programId));
	}

	@PostMapping("/{programId}/subjects")
	@ApiOperation(value = "", nickname = "setStudyProgramSubjects")
	public ResponseEntity<List<Subject>> setStudyProgramSubjects(@PathVariable Integer programId, @RequestBody List<Subject> subjects) {
		return ResponseEntity.ok(studyProgramService.setSubjectsById(programId, subjects));
	}

	@PutMapping("/{programId}/subjects")
	@ApiOperation(value = "", nickname = "addStudyProgramSubjects")
	public ResponseEntity<List<Subject>> addStudyProgramSubjects(@PathVariable Integer programId, @RequestBody List<Subject> subjects) {
		return ResponseEntity.ok(studyProgramService.addSubjectsById(programId, subjects));
	}

	@DeleteMapping("/{programId}/subjects")
	@ApiOperation(value = "", nickname = "deleteStudyProgramSubjects")
	public ResponseEntity<List<Subject>> deleteStudyProgramSubjects(@PathVariable Integer programId, @RequestBody List<Subject> subjects) {
		return ResponseEntity.ok(studyProgramService.deleteSubjectsById(programId, subjects));
	}

}

