package pro.sky.coursework2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
public class MathQuestionException extends RuntimeException {
    public MathQuestionException() {
    }

    public MathQuestionException(String message) {
        super(message);
    }
}
