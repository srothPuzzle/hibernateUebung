package ch.puzzle.pfeedback.question.controller;


import ch.puzzle.pfeedback.question.model.Question;
import ch.puzzle.pfeedback.question.service.QuestionService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.transaction.TransactionalException;
import javax.validation.Valid;


@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public Iterable<Question> findAll() {
        return questionService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Question question) {
        try {
            questionService.create(question);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (TransactionalException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> findById(@PathVariable long id){
        try {
            return new ResponseEntity<>(questionService.findById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> update(@Valid @RequestBody Question question, @PathVariable long id) {
        try {
            return new ResponseEntity<>(questionService.update(question, id),HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Question> delete(@PathVariable long id) {
        try {
            questionService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
