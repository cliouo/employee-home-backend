package top.cliouo.emp.exception.enums;


/**
 * 业务异常的错误码区间，定义错误时先来这里定义一个枚举的错误信息
 */
public enum ServiceExceptionCode {
    USER_NOT_FOUND(400404, "用户名不存在！"),
    USER_PASSWORD_ERROR(400405,"密码错误"),
    FACE_REGISTER_ERROR(400406,"人脸注册失败");

    private final int code;
    private final String message;

    ServiceExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
