package xyz.todooc4.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "project")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Project extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "project_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "abstract")
	private String abstract;
	@Column(name = "key_words")
	private String keyWords;
	
}