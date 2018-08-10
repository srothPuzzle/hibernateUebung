package ch.puzzle.pfeedback.question.service;

import ch.puzzle.pfeedback.question.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
