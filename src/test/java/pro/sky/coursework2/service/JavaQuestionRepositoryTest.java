package pro.sky.coursework2.service;

import org.junit.jupiter.api.Test;
import pro.sky.coursework2.exceptions.QuestionAlreadyExistsException;
import pro.sky.coursework2.exceptions.QuestionNotFoundException;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.coursework2.service.Constants.*;

class JavaQuestionRepositoryTest {

    private final JavaQuestionRepository out = new JavaQuestionRepository();

    @Test
    void shouldAddQuestion() {
        assertEquals(CORRECT_RESPONSE, out.add(CORRECT_QUESTION));
        assertEquals(CORRECT_RESPONSE, out.add(QUESTION2, ANSWER2));
        assertTrue(out.getQuestions().contains(CORRECT_QUESTION));
        assertTrue(out.getQuestions().contains(ANOTHER_QUESTION));

    }

    @Test
    void shouldThrowExceptionIfExists() {
        out.add(CORRECT_QUESTION);
        assertThrows(QuestionAlreadyExistsException.class,
                () -> out.add(QUESTION, ANSWER));
        assertThrows(QuestionAlreadyExistsException.class,
                () -> out.add(CORRECT_QUESTION));
    }
    @Test
    void shouldRemove() {
        out.add(CORRECT_QUESTION);
        out.add(QUESTION2, ANSWER2);
        assertEquals(REMOVAL_RESPONSE, out.remove(CORRECT_QUESTION));
        assertEquals(REMOVAL_RESPONSE, out.remove(QUESTION2, ANSWER2));
        assertFalse(out.getQuestions().contains(CORRECT_QUESTION));
        assertFalse(out.getQuestions().contains(ANOTHER_QUESTION));
    }

    @Test
    void shouldThrowIfNotFound() {
        out.add(CORRECT_QUESTION);
        assertThrows(QuestionNotFoundException.class,
                () -> out.remove(ANOTHER_QUESTION));
        assertThrows(QuestionNotFoundException.class,
                () -> out.remove(QUESTION2, ANSWER2));
    }

    @Test
    void shouldReturnListOfAllQuestions() {
        Collection<Question> expected = List.of(
                new Question(QUESTION, ANSWER),
                new Question(QUESTION2, ANSWER2)
        );
        out.add(QUESTION2, ANSWER2);
        out.add(CORRECT_QUESTION);
        assertTrue(out.findAll().containsAll(expected));
    }

    @Test
    void getNumberOfQuestions() {
        out.add(QUESTION2, ANSWER2);
        out.add(CORRECT_QUESTION);
        assertEquals(NUMBER_OF_QUESTIONS, out.getNumberOfQuestions());
    }
}