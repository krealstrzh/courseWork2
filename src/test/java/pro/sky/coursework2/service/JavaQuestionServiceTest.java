package pro.sky.coursework2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.coursework2.service.Constants.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    private final JavaQuestionRepository repositoryMock = mock(JavaQuestionRepository.class);
    private final Random random = mock(Random.class);

    @InjectMocks
    private JavaQuestionService out;

    @Test
    void shouldReturnRandomQuestion() {
        int number = 2;
        when(repositoryMock.getNumberOfQuestions())
                .thenReturn(AMOUNT_OF_MOCK_QUESTIONS);
        when(repositoryMock.getQuestions())
                .thenReturn(MOCK_REPOSITORY);
        when(random.nextInt(anyInt()))
                .thenReturn(number);
        assertEquals(MOCK2, out.getRandomQuestion());
    }

    @Test
    void shouldReturnNumberOfQuestions() {
        when(repositoryMock.getNumberOfQuestions())
                .thenReturn(NUMBER_OF_QUESTIONS);
        assertEquals(NUMBER_OF_QUESTIONS, out.getNumberOfQuestions());
    }
}