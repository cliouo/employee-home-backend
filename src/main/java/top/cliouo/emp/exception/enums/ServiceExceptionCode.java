package top.cliouo.emp.exception.enums;


/**
 * 业务异常的错误码区间，定义错误时先来这里定义一个枚举的错误信息
 */
public enum ServiceExceptionCode {
    USERNAME_NOT_FOUND(400404, "用户名不存在！"),
    USER_PASSWORD_ERROR(400405, "密码错误"),
    FACE_REGISTER_ERROR(400406, "人脸注册失败"),
    FACE_LOGIN_ERROR(400407, "人脸登录失败"),
    USER_NOT_FOUND(400408, "用户不存在"),
    USER_SAVE_ERROR(400409, "用户保存失败"),
    USERNAME_HAS_EXISTED(400410, "用户名已存在"),
    USER_DELETE_ERROR(400420, "用户删除失败"),
    USER_UPDATE_ERROR(400430, "用户更新失败"),
    JOB_SAVE_ERROR(400500, "职位保存失败"),
    JOB_DELETE_ERROR(400510, "职位删除失败"),
    JOB_NOT_EXIST(400520, "职位不存在"), JOB_UPDATE_ERROR(400530, "职位更新失败");

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
