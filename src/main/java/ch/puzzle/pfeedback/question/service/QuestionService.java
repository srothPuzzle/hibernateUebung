package ch.puzzle.pfeedback.question.service;

import ch.puzzle.pfeedback.question.model.Question;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Iterable<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question create(@Valid Question question) {
        return questionRepository.save(question);
    }

    public Question findById(Long id) {
        return questionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Question update(Question question, long id) {
        Question questionNew = questionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        questionNew.setQuestion(question.getQuestion());
        questionNew.setQuestionType(question.getQuestionType());
        questionRepository.save(questionNew);
        return questionNew;
    }

    public void delete(long id) {
        questionRepository.deleteById(id);
    }
}
