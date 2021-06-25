package xyz.todooc4.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "student")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Student extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "student_id")
	private Integer id;
	@JoinColumn(name = "person_fk", referencedColumnName = "person_id")
	@ManyToOne
	private Person person;
	@Column(name = "study_type")
	private String studyType;
	@Column(name = "stud_email")
	private String studEmail;
	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "student_subject", joinColumns = @JoinColumn(name = "student_fk"), inverseJoinColumns = @JoinColumn(name = "subject_fk"))
	private List<Subject> subjects;
	
}