package pro.sky.coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.exceptions.QuestionAlreadyExistsException;
import pro.sky.coursework2.exceptions.QuestionNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;

    public JavaQuestionService () {
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question quest = new Question(question, answer);
        if (questions.contains(quest)) {
            throw new QuestionAlreadyExistsException();
        }
        questions.add(quest);
        return quest;
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyExistsException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new QuestionNotFoundException();
        }
        questions.remove(question);
        return question;
    }

    public Question remove(String question, String answer) {
        Question quest = new Question(question, answer);
        remove(quest);
        return quest;
    }

    @Override
    public Collection<Question> findAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int number = random.nextInt(questions.size());
        return questions.stream().collect(Collectors.toList()).get(number);
    }

    @Override
    public int getNumberOfQuestions() {
        return questions.size();
    }
}
