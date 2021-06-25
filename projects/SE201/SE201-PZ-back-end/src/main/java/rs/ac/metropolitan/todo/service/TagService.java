package rs.ac.metropolitan.todo.service;

import java.util.Collection;
import java.util.List;
import rs.ac.metropolitan.todo.entity.*;

public  interface TagService {

	List<Tag> findAll();

	Tag save(Tag tag);

	Tag update(Tag tag);

	Tag findById(Integer tagId);

	void deleteById(Integer tagId);

}