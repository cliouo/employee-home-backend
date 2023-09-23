package top.cliouo.emp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class HelloControlloer {

    @PostMapping("hello")
    public String sayHello(@RequestParam String name){
        return name;
    }

    @PostMapping("file")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam String name){
        System.out.println(file.getSize());
        System.out.println(name);
        return "upload file";
    }
}
