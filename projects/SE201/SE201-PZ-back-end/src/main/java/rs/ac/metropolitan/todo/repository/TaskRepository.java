package rs.ac.metropolitan.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.metropolitan.todo.entity.Task;

@Repository
public  interface TaskRepository extends JpaRepository<Task, Integer> {

}