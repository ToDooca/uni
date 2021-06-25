package rs.ac.metropolitan.todo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tag")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Tag extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "tag_id")
	private Integer id;
	@JoinColumn(name = "task_id", referencedColumnName = "task_id")
	@ManyToOne
	private Task taskId;
	@Column(name = "name")
	private String name;
	@Column(name = "color")
	private String color;
	
}