package rs.ac.metropolitan.todo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "employee")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Employee extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "employee_id")
	private Integer id;
	@JoinColumn(name = "task_id", referencedColumnName = "task_id")
	@ManyToOne
	private Task taskId;
	@Column(name = "name")
	private String name;
	
}