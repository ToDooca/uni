package xyz.todooc4.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "person")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Person extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "person_id")
	private Integer id;
	@Column(name = "jmbg")
	private String jmbg;
	@Column(name = "degree_name")
	private String degreeName;
	@Column(name = "surname")
	private String surname;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "email")
	private String email;
	@Column(name = "city_of_birth")
	private String cityOfBirth;
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
}