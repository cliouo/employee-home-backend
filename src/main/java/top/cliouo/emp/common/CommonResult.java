package top.cliouo.emp.common;


import lombok.Data;

@Data
public class CommonResult {

    private ErrorResult error;

    public CommonResult(ErrorResult error) {
        this.error = error;
    }

    public CommonResult() {
    }

    // 成功就直接返回结果
    public static Object success(Object data) {
        return data;
    }

    public static CommonResult error(Integer status, String message) {
        return new CommonResult(new CommonResult.ErrorResult(status, message));
    }

    // 封装个错误返回格式

    public static class ErrorResult {

        private Integer status;
        private String message;

        public ErrorResult() {
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public ErrorResult(Integer status, String message) {
            this.status = status;
            this.message = message;
        }
    }
}
