package com.spring.cloud.advertising.service;

import com.spring.cloud.advertising.entity.Account;
import com.spring.cloud.advertising.service.support.IBaseService;

/**
 * <p>
 * 用户服务类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
public interface IAccountService extends IBaseService<Account, Integer> {

    /**
     * 根据用户名查找用户
     * @param
     * @return
     */
    //Commercial findByName(String commercial_name);

    /**
     * 增加或者修改用户
     * @param account
     */
    void saveOrUpdate(Account account);


}