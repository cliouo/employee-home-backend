package top.cliouo.emp.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult {

    private ErrorRusult error;

    // 成功就直接返回结果
    public static Object success(Object data){
        return data;
    }

    public static CommonResult error(Integer status, String message){
        return new CommonResult(new ErrorRusult(status, message));
    }

    // 封装个错误返回格式
    @Data
    @AllArgsConstructor
    public static class ErrorRusult{

        private Integer status;
        private String message;
    }
}
