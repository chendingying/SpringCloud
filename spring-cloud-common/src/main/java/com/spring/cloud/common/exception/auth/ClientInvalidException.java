package com.spring.cloud.common.exception.auth;



import com.spring.cloud.common.constant.CommonConstants;
import com.spring.cloud.common.exception.BaseException;

/**
 * @author cdy
 * @create 2018/8/27
 */
public class ClientInvalidException extends BaseException {
    public ClientInvalidException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}
