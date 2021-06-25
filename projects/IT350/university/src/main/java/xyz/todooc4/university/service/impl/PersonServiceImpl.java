package xyz.todooc4.university.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.repository.PersonRepository;
import xyz.todooc4.university.service.PersonService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class PersonServiceImpl implements PersonService {
	private final PersonRepository personRepository;

	@Override
	public List<Person> findAll(Specification<Person> specification, Sort sort) {
		return personRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Person findById(Integer personId) {
		return personRepository.findById(personId)
				.orElseThrow(() -> new NoSuchElementException("PersonService.notFound"));
	}

	@Override
	public Person save(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person update(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void deleteById(Integer personId) {
		personRepository.deleteById(personId);
	}


}