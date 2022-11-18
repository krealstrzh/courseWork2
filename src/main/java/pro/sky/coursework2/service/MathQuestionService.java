package pro.sky.coursework2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.exceptions.QuestionAlreadyExistsException;
import pro.sky.coursework2.exceptions.QuestionNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Qualifier ("mathQuestionService")
public class MathQuestionService implements QuestionService {

    private final Random random;

    public MathQuestionService(Random random) {
        this.random = random;
    }

    @Override
    public Question getRandomQuestion() {
        List <String> actions = List.of(" + ", " - ", " * ", " / ");
        int a = random.nextInt(20000) - 10000;
        int b = random.nextInt(20000) - 10000;
        double result = 0;
        int act = random.nextInt(actions.size());
        switch (act) {
            case 0:
                result = a + b;
                break;
            case 1:
                result = a - b;
                break;
            case 2:
                result = a * b;
                break;
            case 3:
                while (b == 0) {
                    b = b + random.nextInt(20000) - 10000;
                }
                result = (a / b)*1.0;
                break;
        }
        String question = a + actions.get(act) + b + "=";
        String answer = String.valueOf(result);
        Question quest = new Question(question, answer);
        return quest;
    }
}
