package xyz.todooc4.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "grading")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Grading extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "grading_id")
	private Integer id;
	@JoinColumn(name = "student_fk", referencedColumnName = "student_id")
	@ManyToOne
	private Student student;
	@JoinColumn(name = "professor_fk", referencedColumnName = "professor_id")
	@ManyToOne
	private Professor professor;
	@JoinColumn(name = "obligation_definition_fk", referencedColumnName = "obligation_definition_id")
	@ManyToOne
	private ObligationDefinition obligationDefinition;
	@Column(name = "file_location")
	private String fileLocation;
	@Column(name = "points")
	private Double points;
	@Column(name = "days_late")
	private Integer daysLate;
	
}