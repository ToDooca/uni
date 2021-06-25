package xyz.todooc4.university.entity;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "professor")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Professor extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "professor_id")
	private Integer id;
	@JoinColumn(name = "person_fk", referencedColumnName = "person_id")
	@ManyToOne
	private Person person;
	@Column(name = "study_title")
	private String studyTitle;
	@Column(name = "professor_email")
	private String professorEmail;
	
}