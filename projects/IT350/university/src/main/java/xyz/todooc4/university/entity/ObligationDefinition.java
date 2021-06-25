package xyz.todooc4.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "obligation_definition")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ObligationDefinition extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "obligation_definition_id")
	private Integer id;
	@JoinColumn(name = "homework_obligation_fk", referencedColumnName = "homework_obligation_id")
	@ManyToOne
	private HomeworkObligation homeworkObligation;
	@JoinColumn(name = "project_obligation_fk", referencedColumnName = "project_obligation_id")
	@ManyToOne
	private ProjectObligation projectObligation;
	@JoinColumn(name = "test_obligation_fk", referencedColumnName = "test_obligation_id")
	@ManyToOne
	private TestObligation testObligation;
	@Column(name = "max_points")
	private Double maxPoints;
	
}