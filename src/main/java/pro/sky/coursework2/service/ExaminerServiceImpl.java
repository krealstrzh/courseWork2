package pro.sky.coursework2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.exceptions.IllegalInputException;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {


    private final JavaQuestionService javaQuestionService;
    private final MathQuestionService mathQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getNumberOfQuestions()) {
            throw new IllegalInputException("Your amount exceeds amount of questions in storage!");
        }
        Set<Question> randomQuestions = new HashSet<>(amount);
        Random random = new Random();
        int javaQuestionsAmount = random.nextInt(amount)+1;
        int mathQuestionsAmount = amount - javaQuestionsAmount;
        while (javaQuestionsAmount > 0) {
            randomQuestions.add(javaQuestionService.getRandomQuestion());
            javaQuestionsAmount--;
        }
        while (mathQuestionsAmount > 0) {
            randomQuestions.add(mathQuestionService.getRandomQuestion());
            mathQuestionsAmount--;
        }
        return randomQuestions;
    }
}
