package top.cliouo.emp.controller.job;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.cliouo.emp.controller.job.vo.JobAddReqVO;
import top.cliouo.emp.service.job.JobService;

@RestController
@RequestMapping("job")
public class JobController {

    @Autowired
    JobService jobService;

    @PostMapping
    public Object addJob(@RequestBody @Valid JobAddReqVO ReqVO){
        return jobService.save(ReqVO);
    }
}
