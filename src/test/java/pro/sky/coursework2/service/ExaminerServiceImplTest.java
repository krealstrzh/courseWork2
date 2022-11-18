package pro.sky.coursework2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.exceptions.IllegalInputException;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pro.sky.coursework2.service.Constants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    private final JavaQuestionService questionMock = mock(JavaQuestionService.class);

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    void shouldGiveQuestions() {
        when(questionMock.getNumberOfQuestions())
                .thenReturn(AMOUNT_OF_MOCK_QUESTIONS);
        when(questionMock.getRandomQuestion())
                .thenReturn(MOCK1, MOCK2);
        Set<Question> expected = Set.of(MOCK1, MOCK2);
        assertEquals(out.getQuestions(2), expected);
    }

    @Test
    void shouldThrowExceptionForAmount() {
        when(questionMock.getNumberOfQuestions())
                .thenReturn(AMOUNT_OF_MOCK_QUESTIONS);
        assertThrows(IllegalInputException.class,
                () -> out.getQuestions(WRONG_AMOUNT));
    }
}