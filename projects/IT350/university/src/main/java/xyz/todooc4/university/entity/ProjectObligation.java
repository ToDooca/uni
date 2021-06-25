package xyz.todooc4.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "project_obligation")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class ProjectObligation extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "project_obligation_id")
	private Integer id;
	@JoinColumn(name = "project_fk", referencedColumnName = "project_id")
	@ManyToOne
	private Project project;
	@Column(name = "file_location")
	private String fileLocation;
	@Column(name = "date_sent")
	private LocalDateTime dateSent;
	
}