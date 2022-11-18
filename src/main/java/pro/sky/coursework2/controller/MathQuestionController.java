package pro.sky.coursework2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.exceptions.MathQuestionException;
import pro.sky.coursework2.service.Question;
import pro.sky.coursework2.service.QuestionService;

import java.util.Collection;


@RestController
@RequestMapping("/math")
public class MathQuestionController {

    @Qualifier("mathQuestionService")
    public final QuestionService mathQuestionService;

    @Autowired
    public MathQuestionController(QuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        throw new MathQuestionException();
    }

    @GetMapping ("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        throw new MathQuestionException();
    }

    @GetMapping
    public Collection<Question> getAll() {
        throw new MathQuestionException();
    }
}
