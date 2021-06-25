package xyz.todooc4.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "faculty")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Faculty extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "faculty_id")
	private Integer id;
	@Column(name = "faculty_name")
	private String facultyName;
	
}