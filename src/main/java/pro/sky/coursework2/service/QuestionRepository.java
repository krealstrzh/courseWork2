package pro.sky.coursework2.service;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface QuestionRepository {
    String add(String question, String answer);

    String add(Question question);

    String remove(Question question);

    String remove(String question, String answer);

    Collection<Question> findAll();

    int getNumberOfQuestions();

    Set<Question> getQuestions();
}
