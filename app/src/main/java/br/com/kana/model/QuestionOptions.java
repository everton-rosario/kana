package br.com.kana.model;

/**
 * Created by aristides on 02/03/15.
 */
public class QuestionOptions {
    private String text;
    private boolean correct;

    public QuestionOptions(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
