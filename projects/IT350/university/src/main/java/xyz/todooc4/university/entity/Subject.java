package xyz.todooc4.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "subject")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Subject extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "subject_id")
	private Integer id;
	@JoinColumn(name = "professor_fk", referencedColumnName = "professor_id")
	@ManyToOne
	private Professor professor;
	@Column(name = "subject_code")
	private String subjectCode;
	@Column(name = "subject_name")
	private String subjectName;
	@Column(name = "espb")
	private Integer espb;
	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "program_subject", joinColumns = @JoinColumn(name = "subject_fk"), inverseJoinColumns = @JoinColumn(name = "program_fk"))
	private List<StudyProgram> studyPrograms;
	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "student_subject", joinColumns = @JoinColumn(name = "subject_fk"), inverseJoinColumns = @JoinColumn(name = "student_fk"))
	private List<Student> students;
	
}