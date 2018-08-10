package ch.puzzle.pfeedback.answer.model;

import ch.puzzle.pfeedback.answer.model.Answer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TextAnswer extends Answer<String> {

    @Override
    public String toString() {
        return answer;
    }
}
