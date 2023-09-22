package top.cliouo.emp.controller.dept;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.cliouo.emp.controller.dept.vo.DeptAddReqVO;
import top.cliouo.emp.controller.dept.vo.DeptPageReqVO;
import top.cliouo.emp.controller.dept.vo.DeptUpdateReqVO;
import top.cliouo.emp.convert.DeptConvert;
import top.cliouo.emp.service.dept.DeptService;

@RestController
@RequestMapping("dept")
@SaCheckLogin
public class DeptController {

    @Autowired
    DeptService deptService;

    @Autowired
    DeptConvert deptConvert;

    @PostMapping
    @SaCheckRole("admin")
    public Object addDept(@RequestBody @Valid DeptAddReqVO ReqVO) {
        return deptService.save(ReqVO);
    }

    @DeleteMapping("{id}")
    @SaCheckRole("admin")
    public Object deleteDept(@PathVariable("id") Long id) {
        return deptService.delete(id);
    }

    @PutMapping("{id}")
    @SaCheckRole("admin")
    public Object updateDept(@PathVariable("id") Long id, @RequestBody @Valid DeptUpdateReqVO reqVO) {
        return deptService.modify(id, reqVO);
    }

    @GetMapping("{id}")
    public Object getDept(@PathVariable("id") Long id) {
        return deptConvert.convert(deptService.get(id));
    }

    @GetMapping
    public Object deptPage(@Valid DeptPageReqVO reqVO) {
        return deptService.deptPage(reqVO);
    }
}
