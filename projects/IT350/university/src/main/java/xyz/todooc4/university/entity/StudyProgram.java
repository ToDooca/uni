package xyz.todooc4.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "study_program")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class StudyProgram extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "program_id")
	private Integer id;
	@JoinColumn(name = "faculty_fk", referencedColumnName = "faculty_id")
	@ManyToOne
	private Faculty faculty;
	@Column(name = "study_name")
	private String studyName;
	@Column(name = "duration")
	private Integer duration;
	@Column(name = "min_espb")
	private Integer minEspb;
	@Column(name = "study_title")
	private String studyTitle;
	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "program_subject", joinColumns = @JoinColumn(name = "program_fk"), inverseJoinColumns = @JoinColumn(name = "subject_fk"))
	private List<Subject> subjects;
	
}