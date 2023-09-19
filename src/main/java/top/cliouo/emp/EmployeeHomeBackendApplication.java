package top.cliouo.emp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("top.cliouo.emp.mapper")
@SpringBootApplication
public class EmployeeHomeBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeHomeBackendApplication.class, args);
    }

}
