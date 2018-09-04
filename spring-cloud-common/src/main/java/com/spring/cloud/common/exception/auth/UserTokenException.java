package com.spring.cloud.common.exception.auth;



import com.spring.cloud.common.constant.CommonConstants;
import com.spring.cloud.common.exception.BaseException;

/**
 * @author cdy
 * @create 2018/8/27
 */
public class UserTokenException extends BaseException {
    public UserTokenException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }
}
