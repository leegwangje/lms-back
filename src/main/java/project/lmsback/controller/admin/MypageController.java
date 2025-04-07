package project.lmsback.controller.admin;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MypageController {

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }
}

