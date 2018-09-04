package com.spring.cloud.common.msg.auth;

import com.github.liansen.security.common.constant.RestCodeConstants;
import com.github.liansen.security.common.msg.BaseResponse;

/**
 * @author cdy
 * @create 2018/8/27
 */
public class TokenForbiddenResponse  extends BaseResponse {
    public TokenForbiddenResponse(String message) {
        super(RestCodeConstants.TOKEN_FORBIDDEN_CODE, message);
    }
}
