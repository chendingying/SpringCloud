package com.spring.cloud.advertising.dao;

import com.spring.cloud.advertising.dao.support.IBaseDao;
import com.spring.cloud.advertising.entity.Information;
import org.springframework.stereotype.Repository;

@Repository
public interface IInformationDao extends IBaseDao<Information, Integer> {

    //Commercial findByName(String commercial_name);

}
