package com.spring.cloud.advertising.dao;

import com.spring.cloud.advertising.dao.support.IBaseDao;
import com.spring.cloud.advertising.entity.PointRule;
import org.springframework.stereotype.Repository;

@Repository
public interface IPointRuleDao extends IBaseDao<PointRule, Integer> {

    //Commercial findByName(String commercial_name);

}
