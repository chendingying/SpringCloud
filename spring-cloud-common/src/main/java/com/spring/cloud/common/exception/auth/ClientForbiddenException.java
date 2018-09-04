package com.spring.cloud.common.exception.auth;


import com.spring.cloud.common.constant.CommonConstants;
import com.spring.cloud.common.exception.BaseException;

/**
 * @author cdy
 * @create 2018/8/27
 */
public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, CommonConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}
