package top.cliouo.emp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControlloer {

    @GetMapping("hello")
    public String sayHello(@RequestParam String name){
        return "hello world";
    }
}
