package rs.ac.metropolitan.todo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "task")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Task extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "task_id")
	private Integer id;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "image")
	private String image;
	@Column(name = "createdat")
	private LocalDateTime createdat;
	@Column(name = "issuetype")
	private String issuetype;
	
}