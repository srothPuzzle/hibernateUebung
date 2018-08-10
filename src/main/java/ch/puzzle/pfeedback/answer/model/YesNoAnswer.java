package ch.puzzle.pfeedback.answer.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class YesNoAnswer extends Answer<YesNoAnswerType> {

    public String YesNoAnswer(YesNoAnswerType yesNoAnswerType){
        if(yesNoAnswerType == YesNoAnswerType.YES){
            return "YES";
        }
        else if (yesNoAnswerType == YesNoAnswerType.NO){
            return "NO";
        }
        else if (yesNoAnswerType == YesNoAnswerType.NOTHING){
            return "";
        }
        else{
            return "Error";
        }
    }

    @Override
    public String toString() { return answer.toString(); }
}
