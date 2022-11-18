package pro.sky.coursework2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.service.*;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {

    @Qualifier ("javaQuestionRepository")
    public final QuestionRepository javaQuestionRepository;

    @Autowired
    public JavaQuestionController(QuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @GetMapping("/add")
    public String add(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionRepository.add(question, answer);
    }

    @GetMapping ("/remove")
    public String removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionRepository.remove(question, answer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return javaQuestionRepository.findAll();
    }
}
