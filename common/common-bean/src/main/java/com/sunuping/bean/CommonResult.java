package com.sunuping.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lime
 * 统一接口结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CommonResult<T> implements Serializable {

    public static int OK = 0;
    /**
     * 未知错误
     **/
    public static int UNKNOWN_ERROR = -1001;
    /**
     * 参数错误
     **/
    public static int PARAMETER_ERROR = -1002;
    /**
     * Token过期
     **/
    public static int TOKEN_EXPIRE = -1003;
    /**
     * 请求超时
     **/
    public static int REQUEST_TIMEOUT = -1004;
    /**
     * 签名错误
     **/
    public static int SIGN_ERROR = -1005;
    /**
     * 请不要频繁操作
     **/
    public static int REPEAT_SUBMIT = -1006;
    /**
     * 异常提示消息
     */
    public static int MSG_EXCEPTION = -1007;
    /**
     * 用户锁定
     */
    public static int ENABLE_EXCEPTION = -1008;
    /**
     * 用户不存在
     */
    public static int USER_NOT_EXIST = -1009;

    private int code;
    private String info;
    private T data;

    public static <T> CommonResult<T> ok(T data) {
        return new CommonResult<T>().setData(data);
    }

    public static <T> CommonResult<T> fail() {
        return new CommonResult<T>().setCode(UNKNOWN_ERROR);
    }

}
