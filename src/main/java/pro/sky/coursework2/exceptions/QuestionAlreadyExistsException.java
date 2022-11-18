package pro.sky.coursework2.exceptions;

public class QuestionAlreadyExistsException extends RuntimeException {

    public QuestionAlreadyExistsException() {
    }

    public QuestionAlreadyExistsException(String message) {
        super(message);
    }
}
