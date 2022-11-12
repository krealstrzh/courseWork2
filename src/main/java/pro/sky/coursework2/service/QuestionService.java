package pro.sky.coursework2.service;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Question remove(String question, String answer);

    Collection<Question> findAll();

    Question getRandomQuestion();

    int getNumberOfQuestions();
}
