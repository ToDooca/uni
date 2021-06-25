package rs.ac.metropolitan.todo.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.todo.entity.*;

public  interface TaskService {

	List<Task> findAll();

	Task save(Task task);

	Task update(Task task);

	Task findById(Integer taskId);

	void deleteById(Integer taskId);

}