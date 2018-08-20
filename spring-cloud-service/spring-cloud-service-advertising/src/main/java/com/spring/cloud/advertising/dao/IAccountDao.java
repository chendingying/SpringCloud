package com.spring.cloud.advertising.dao;

import com.spring.cloud.advertising.dao.support.IBaseDao;
import com.spring.cloud.advertising.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountDao extends IBaseDao<Account, Integer> {

    //Commercial findByName(String commercial_name);

}
