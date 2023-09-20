package top.cliouo.emp.error;

import cn.dev33.satoken.exception.SaTokenException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import top.cliouo.emp.exception.enums.SaTokenExceptionCode;
import top.cliouo.emp.util.CommonResult;

import static top.cliouo.emp.util.CommonResult.error;


@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理 SpringMVC 请求参数缺失 400
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public CommonResult missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException ex){
        return error(HttpStatus.BAD_REQUEST.value(), String.format("请求参数缺失:%s", ex.getParameterName()));
    }

    /**
     * 处理 SpringMVC 请求参数类型错误
     *
     * 例如说，接口上设置了 @RequestParam("xx") 参数为 Integer，结果传递 xx 参数类型为 String
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public CommonResult methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException ex) {
        return error(HttpStatus.BAD_REQUEST.value(), String.format("请求参数类型错误:%s", ex.getMessage()));
    }

    /**
     * 处理 SpringMVC 参数校验不正确
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult methodArgumentNotValidExceptionExceptionHandler(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        return error(HttpStatus.BAD_REQUEST.value(), String.format("请求参数不正确:%s", fieldError.getDefaultMessage()));
    }

    /**
     * 处理 SpringMVC 参数绑定不正确，本质上也是通过 Validator 校验
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public CommonResult bindExceptionHandler(BindException ex) {
        FieldError fieldError = ex.getFieldError();
        return error(HttpStatus.BAD_REQUEST.value(), String.format("请求参数不正确:%s", fieldError.getDefaultMessage()));
    }

    /**
     * 处理 Validator 校验不通过产生的异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ConstraintViolationException.class)
    public CommonResult constraintViolationExceptionHandler(ConstraintViolationException ex) {
        ConstraintViolation<?> constraintViolation = ex.getConstraintViolations().iterator().next();
        return error(HttpStatus.BAD_REQUEST.value(), String.format("请求参数不正确:%s", constraintViolation.getMessage()));
    }

    /**
     * 处理 SpringMVC 请求地址不存在
     *
     * 注意，它需要设置如下两个配置项：
     * 1. spring.mvc.throw-exception-if-no-handler-found 为 true
     * 2. spring.mvc.static-path-pattern 为 /statics/**
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public CommonResult noHandlerFoundExceptionHandler(NoHandlerFoundException ex) {
        return error(HttpStatus.NOT_FOUND.value(), String.format("请求地址不存在:%s", ex.getRequestURL()));
    }

    /**
     * 处理 SpringMVC 请求方法不正确
     *
     * 例如说，A 接口的方法为 GET 方式，结果请求方法为 POST 方式，导致不匹配
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CommonResult httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException ex) {
        return error(HttpStatus.METHOD_NOT_ALLOWED.value(), String.format("请求方法不正确:%s", ex.getMessage()));
    }


    /**
     * 处理 Sa-Token 异常
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(SaTokenException.class)
    public CommonResult handlerSaTokenException(SaTokenException ex) {
        SaTokenExceptionCode exceptionCode = SaTokenExceptionCode.getExceptionCode(ex.getCode());
        if (exceptionCode != SaTokenExceptionCode.UNDEFINED) {
             return error(exceptionCode.getCode(), exceptionCode.getMessage());
        }
        return error(HttpStatus.FORBIDDEN.value(),"认证服务器繁忙，请稍后重试...");
    }
    /**
     * 处理系统异常，兜底处理所有的一切
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public CommonResult defaultExceptionHandler(Throwable ex) {
        // 返回 ERROR CommonResult
        return CommonResult.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }

}
