package xyz.todooc4.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "homework_obligation")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class HomeworkObligation extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "homework_obligation_id")
	private Integer id;
	@JoinColumn(name = "homework_fk", referencedColumnName = "homework_id")
	@ManyToOne
	private Homework homework;
	@Column(name = "file_location")
	private String fileLocation;
	@Column(name = "date_sent")
	private LocalDateTime dateSent;
	
}