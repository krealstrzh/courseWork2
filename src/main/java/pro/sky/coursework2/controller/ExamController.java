package pro.sky.coursework2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.service.ExaminerService;
import pro.sky.coursework2.service.Question;

import java.util.Set;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    @Autowired
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get")
    public Set<Question> getQuestions(@RequestParam int amount) {
        return examinerService.getQuestions(amount);
    }
}
