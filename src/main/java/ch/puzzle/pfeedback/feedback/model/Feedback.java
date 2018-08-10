package ch.puzzle.pfeedback.feedback.model;

import ch.puzzle.pfeedback.answer.model.Answer;
import ch.puzzle.pfeedback.user.model.User;
import ch.puzzle.pfeedback.topic.model.Topic;
import lombok.Builder;
import lombok.Data;

import java.util.Set;


@Data
@Builder
public class Feedback {

    private Topic topic;
    private Set<Answer> answerSet;
    private User receiver;
    private User sender;

}
