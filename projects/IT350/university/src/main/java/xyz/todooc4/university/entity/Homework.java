package xyz.todooc4.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "homework")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Homework extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "homework_id")
	private Integer id;
	@Column(name = "number")
	private Integer number;
	@Column(name = "text")
	private String text;
	
}