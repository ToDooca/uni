package xyz.todooc4.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "question")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Question extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "question_id")
	private Integer id;
	@Column(name = "quesstion_text")
	private String quesstionText;
	
}