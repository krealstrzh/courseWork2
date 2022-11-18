package pro.sky.coursework2.service;

import pro.sky.coursework2.exceptions.QuestionAlreadyExistsException;
import pro.sky.coursework2.exceptions.QuestionNotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public JavaQuestionRepository () {
        this.questions = new HashSet<>();
    }

    @Override
    public String add(String question, String answer) {
        Question quest = new Question(question, answer);
        if (questions.contains(quest)) {
            throw new QuestionAlreadyExistsException();
        }
        questions.add(quest);
        return "Question successfully added!";
    }

    @Override
    public String add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyExistsException();
        }
        questions.add(question);
        return "Question successfully added!";
    }

    @Override
    public String remove(Question question) {
        if (!questions.remove(question)) {
            throw new QuestionNotFoundException();
        }
        questions.remove(question);
        return "Question successfully removed!";
    }

    @Override
    public String remove (String question, String answer) {
        Question quest = new Question(question, answer);
        remove(quest);
        return "Question successfully removed!";
    }

    @Override
    public Collection<Question> findAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public int getNumberOfQuestions() {
        return questions.size();
    }

    @Override
    public Set<Question> getQuestions() {
        return questions;
    }
}
