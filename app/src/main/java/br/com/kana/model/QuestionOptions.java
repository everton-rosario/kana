package br.com.kana.model;

/**
 * Created by aristides on 02/03/15.
 */
public class QuestionOptions {
    private String value;
    private boolean correct;

    public QuestionOptions(String value, boolean correct) {
        this.value = value;
        this.correct = correct;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
