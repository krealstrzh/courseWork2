package pro.sky.coursework2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    private Random randomMock = mock(Random.class);

    @InjectMocks
    private MathQuestionService out;

    @Test
    void getRandomQuestion() {
        when(randomMock.nextInt(any()))
                .thenReturn(2);
        Question expected = new Question("2*2=", "4");
        assertEquals(expected, out.getRandomQuestion());
    }
}