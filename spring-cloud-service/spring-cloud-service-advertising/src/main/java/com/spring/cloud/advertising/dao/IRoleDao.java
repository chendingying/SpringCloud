package com.spring.cloud.advertising.dao;

import com.spring.cloud.advertising.dao.support.IBaseDao;
import com.spring.cloud.advertising.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleDao extends IBaseDao<Role, Integer> {

}
