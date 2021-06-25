package rs.ac.metropolitan.todo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.todo.entity.*;
import rs.ac.metropolitan.todo.repository.EmployeeRepository;
import rs.ac.metropolitan.todo.service.EmployeeService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(Integer employeeId) {
		return employeeRepository.findById(employeeId)
				.orElseThrow(() -> new NoSuchElementException("EmployeeService.notFound"));
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee update(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteById(Integer employeeId) {
		employeeRepository.deleteById(employeeId);
	}


}