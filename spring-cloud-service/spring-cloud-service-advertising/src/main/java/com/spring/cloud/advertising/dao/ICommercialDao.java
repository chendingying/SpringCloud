package com.spring.cloud.advertising.dao;

import com.spring.cloud.advertising.dao.support.IBaseDao;
import com.spring.cloud.advertising.entity.Commercial;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommercialDao extends IBaseDao<Commercial, Integer> {

    //Commercial findByName(String commercial_name);

}
