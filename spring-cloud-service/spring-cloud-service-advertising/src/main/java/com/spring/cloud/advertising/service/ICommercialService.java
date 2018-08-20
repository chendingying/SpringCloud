package com.spring.cloud.advertising.service;

import com.spring.cloud.advertising.entity.Commercial;
import com.spring.cloud.advertising.service.support.IBaseService;
/**
 * <p>
 * 用户服务类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
public interface ICommercialService extends IBaseService<Commercial, Integer> {

    /**
     * 根据用户名查找用户
     * @param commercial_name
     * @return
     */
    //Commercial findByName(String commercial_name);

    /**
     * 增加或者修改用户
     * @param commercial
     */
    void saveOrUpdate(Commercial commercial);


}
