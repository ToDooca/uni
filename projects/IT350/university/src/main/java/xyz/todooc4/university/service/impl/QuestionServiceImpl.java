package xyz.todooc4.university.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.repository.QuestionRepository;
import xyz.todooc4.university.service.QuestionService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class QuestionServiceImpl implements QuestionService {
	private final QuestionRepository questionRepository;

	@Override
	public List<Question> findAll(Specification<Question> specification, Sort sort) {
		return questionRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Question findById(Integer questionId) {
		return questionRepository.findById(questionId)
				.orElseThrow(() -> new NoSuchElementException("QuestionService.notFound"));
	}

	@Override
	public Question save(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public Question update(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public void deleteById(Integer questionId) {
		questionRepository.deleteById(questionId);
	}


}