package rs.ac.metropolitan.todo.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.todo.entity.*;
import rs.ac.metropolitan.todo.repository.TagRepository;
import rs.ac.metropolitan.todo.service.TagService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class TagServiceImpl implements TagService {
	private final TagRepository tagRepository;

	@Override
	public List<Tag> findAll() {
		return tagRepository.findAll();
	}

	@Override
	public Tag findById(Integer tagId) {
		return tagRepository.findById(tagId)
				.orElseThrow(() -> new NoSuchElementException("TagService.notFound"));
	}

	@Override
	public Tag save(Tag tag) {
		return tagRepository.save(tag);
	}

	@Override
	public Tag update(Tag tag) {
		return tagRepository.save(tag);
	}

	@Override
	public void deleteById(Integer tagId) {
		tagRepository.deleteById(tagId);
	}


}