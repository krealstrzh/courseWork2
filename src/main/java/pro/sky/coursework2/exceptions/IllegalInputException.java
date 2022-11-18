package pro.sky.coursework2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IllegalInputException extends RuntimeException {
    public IllegalInputException() {
    }

    public IllegalInputException(String message) {
        super(message);
    }
}
