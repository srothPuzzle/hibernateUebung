package ch.puzzle.pfeedback.answer.model;

public abstract class Answer<T> {

    protected T answer;

    public void setAnswer(T answer) { this.answer = answer; }
    public T getAnswer()   { return answer; }

}