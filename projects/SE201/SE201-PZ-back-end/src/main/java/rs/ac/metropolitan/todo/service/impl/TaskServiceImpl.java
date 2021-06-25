package rs.ac.metropolitan.todo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.todo.entity.*;
import rs.ac.metropolitan.todo.repository.TaskRepository;
import rs.ac.metropolitan.todo.service.TaskService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class TaskServiceImpl implements TaskService {
	private final TaskRepository taskRepository;

	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	@Override
	public Task findById(Integer taskId) {
		return taskRepository.findById(taskId)
				.orElseThrow(() -> new NoSuchElementException("TaskService.notFound"));
	}

	@Override
	public Task save(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Task update(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public void deleteById(Integer taskId) {
		taskRepository.deleteById(taskId);
	}


}