package project.lmsback.controller.professor;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyCoursesController {

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }
}

