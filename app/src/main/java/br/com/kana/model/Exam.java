package br.com.kana.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aristides on 02/03/15.
 */
public class Exam {
    private List<Question> questions = new ArrayList<>();

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
