package xyz.todooc4.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "student_obligation")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class StudentObligation extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "student_obligation_id")
	private Integer id;
	@JoinColumn(name = "student_fk", referencedColumnName = "student_id")
	@ManyToOne
	private Student student;
	@JoinColumn(name = "obligation_definition_fk", referencedColumnName = "obligation_definition_id")
	@ManyToOne
	private ObligationDefinition obligationDefinition;
	@Column(name = "date_sent")
	private LocalDateTime dateSent;
	@Column(name = "file_location")
	private String fileLocation;
	
}