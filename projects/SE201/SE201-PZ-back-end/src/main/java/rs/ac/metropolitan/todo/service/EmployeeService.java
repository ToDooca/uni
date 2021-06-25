package rs.ac.metropolitan.todo.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.todo.entity.*;

public  interface EmployeeService {

	List<Employee> findAll();

	Employee save(Employee employee);

	Employee update(Employee employee);

	Employee findById(Integer employeeId);

	void deleteById(Integer employeeId);

}