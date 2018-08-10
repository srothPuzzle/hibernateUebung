package ch.puzzle.pfeedback.topic.service;

import ch.puzzle.pfeedback.topic.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Long> {

}
