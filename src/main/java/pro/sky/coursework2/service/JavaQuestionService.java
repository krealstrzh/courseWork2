package pro.sky.coursework2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.exceptions.QuestionAlreadyExistsException;
import pro.sky.coursework2.exceptions.QuestionNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Qualifier ("javaQuestionService")
public class JavaQuestionService implements QuestionService {

    @Qualifier ("javaQuestionRepository")
    private final QuestionRepository javaQuestionRepository;
    private Random random;


    @Autowired
    public JavaQuestionService(QuestionRepository javaQuestionRepository, Random random) {
        this.javaQuestionRepository = javaQuestionRepository;
        this.random = new Random();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int number = random.nextInt(javaQuestionRepository.getNumberOfQuestions());
        Question quest = javaQuestionRepository.getQuestions().stream()
                .collect(Collectors.toList())
                .get(number);
        return quest;
    }

    public int getNumberOfQuestions() {
        return javaQuestionRepository.getNumberOfQuestions();
    }
}
