package pro.sky.coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.exceptions.IllegalInputException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Set<Question> getQuestions(int amount) {
        if (amount > questionService.getNumberOfQuestions()) {
            throw new IllegalInputException("Your amount exceeds amount of questions in storage!");
        }
        Set<Question> randomQuestions = new HashSet<>();
        for (int i = 0; i < amount; i++) {
            randomQuestions.add(questionService.getRandomQuestion());
        }
        return randomQuestions;
    }
}
