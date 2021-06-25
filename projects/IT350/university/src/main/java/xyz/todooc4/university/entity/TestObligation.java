package xyz.todooc4.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "test_obligation")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class TestObligation extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "test_obligation_id")
	private Integer id;
	@JoinColumn(name = "test_fk", referencedColumnName = "test_id")
	@ManyToOne
	private Test test;
	@Column(name = "file_location")
	private String fileLocation;
	@Column(name = "date_sent")
	private LocalDateTime dateSent;
	
}