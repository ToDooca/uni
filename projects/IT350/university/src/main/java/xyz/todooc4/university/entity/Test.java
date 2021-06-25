package xyz.todooc4.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "test")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Test extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "test_id")
	private Integer id;
	@JoinColumn(name = "question_fk", referencedColumnName = "question_id")
	@ManyToOne
	private Question question;
	@Column(name = "test_num")
	private Integer testNum;
	
}