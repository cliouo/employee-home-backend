package top.cliouo.emp.controller.job;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.cliouo.emp.controller.job.vo.JobAddReqVO;
import top.cliouo.emp.controller.job.vo.JobPageReqVO;
import top.cliouo.emp.controller.job.vo.JobUpdateReqVO;
import top.cliouo.emp.convert.JobConvert;
import top.cliouo.emp.service.job.JobService;

@RestController
@RequestMapping("job")
@SaCheckLogin
public class JobController {

    @Autowired
    JobService jobService;

    @PostMapping
    @SaCheckRole("admin")
    public Object addJob(@RequestBody @Valid JobAddReqVO ReqVO) {
        return jobService.save(ReqVO);
    }

    @DeleteMapping("{id}")
    @SaCheckRole("admin")
    public Object deleteJob(@PathVariable("id") Long id) {
        return jobService.delete(id);
    }

    @PutMapping("{id}")
    @SaCheckRole("admin")
    public Object updateJob(@PathVariable("id") Long id, @RequestBody @Valid JobUpdateReqVO reqVO) {
        return jobService.modify(id, reqVO);
    }

    @GetMapping("{id}")
    public Object getJob(@PathVariable("id") Long id) {
        return JobConvert.INSTANCE.convert(jobService.get(id));
    }

    @GetMapping
    public Object jobPage(@Valid JobPageReqVO reqVO) {
        return jobService.jobPage(reqVO);
    }
}
