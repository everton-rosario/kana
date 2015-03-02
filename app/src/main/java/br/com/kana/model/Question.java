package br.com.kana.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aristides on 02/03/15.
 */
public class Question {
    private String text;
    private List<QuestionOptions> questionOptions = new ArrayList<>();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<QuestionOptions> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(List<QuestionOptions> questionOptions) {
        this.questionOptions = questionOptions;
    }
}
