package ch.puzzle.pfeedback.topic.service;

import ch.puzzle.pfeedback.topic.model.Topic;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;


@Service
public class TopicService {
    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Iterable<Topic> findAll() {
        return topicRepository.findAll();
    }

    public Topic create(@Valid Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic findById(long id) {
            return topicRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Topic update(final Topic topic, long id) {
        Topic topicNew = topicRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        topicNew.setName(topic.getName());
        topicRepository.save(topicNew);
        return topicNew;
    }

    public void delete(long id) {
            topicRepository.deleteById(id);
        }
}
