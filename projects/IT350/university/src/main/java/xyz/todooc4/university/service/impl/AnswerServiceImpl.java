package xyz.todooc4.university.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.todooc4.university.entity.*;
import xyz.todooc4.university.repository.AnswerRepository;
import xyz.todooc4.university.service.AnswerService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class AnswerServiceImpl implements AnswerService {
	private final AnswerRepository answerRepository;

	@Override
	public List<Answer> findAll(Specification<Answer> specification, Sort sort) {
		return answerRepository.findAll(specification, sort == null ? Sort.unsorted() : sort);
	}

	@Override
	public Answer findById(Integer answerId) {
		return answerRepository.findById(answerId)
				.orElseThrow(() -> new NoSuchElementException("AnswerService.notFound"));
	}

	@Override
	public Answer save(Answer answer) {
		return answerRepository.save(answer);
	}

	@Override
	public Answer update(Answer answer) {
		return answerRepository.save(answer);
	}

	@Override
	public void deleteById(Integer answerId) {
		answerRepository.deleteById(answerId);
	}


}