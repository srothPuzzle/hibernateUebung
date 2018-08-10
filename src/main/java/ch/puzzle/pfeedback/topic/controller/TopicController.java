package ch.puzzle.pfeedback.topic.controller;

import ch.puzzle.pfeedback.topic.model.Topic;
import ch.puzzle.pfeedback.topic.service.TopicService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.persistence.TransactionRequiredException;
import javax.transaction.TransactionalException;
import javax.validation.Valid;


@RestController
@RequestMapping("/topic")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public Iterable<Topic> findAll() {
        return topicService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Topic topic) {
        try {
            topicService.create(topic);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (TransactionalException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> findById(@PathVariable long id){
        try {
            return new ResponseEntity<Topic>(topicService.findById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Topic topic, @PathVariable long id) {
        try {
            topicService.update(topic, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@Valid @PathVariable long id) {
        try {
            topicService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
