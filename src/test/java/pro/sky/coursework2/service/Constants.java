package pro.sky.coursework2.service;

import java.util.Set;

public class Constants {

    public static final String QUESTION = "Question";
    public static final String ANSWER = "Answer";
    public static final String QUESTION2 = "Question2";
    public static final String ANSWER2 = "Answer2";
    public static final Question CORRECT_QUESTION = new Question(QUESTION, ANSWER);
    public static final Question ANOTHER_QUESTION = new Question(QUESTION2, ANSWER2);
    public static final int NUMBER_OF_QUESTIONS = 2;

    public static final String CORRECT_RESPONSE = "Question successfully added!";
    public static final String REMOVAL_RESPONSE = "Question successfully removed!";

    public static final Question MOCK1 = new Question("Кто я?", "Аянами Рей");
    public static final Question MOCK2 = new Question("А кто ты?", "Аянами Рей");
    public static final Set<Question> MOCK_REPOSITORY = Set.of(MOCK1, MOCK2);
    public static final int AMOUNT_OF_MOCK_QUESTIONS = 2;
    public static final int WRONG_AMOUNT = 4;
}
