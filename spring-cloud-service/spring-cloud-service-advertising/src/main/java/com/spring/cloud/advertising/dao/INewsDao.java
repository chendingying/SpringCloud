package com.spring.cloud.advertising.dao;

import com.spring.cloud.advertising.dao.support.IBaseDao;
import com.spring.cloud.advertising.entity.News;
import org.springframework.stereotype.Repository;

@Repository
public interface INewsDao extends IBaseDao<News, Integer> {

    //Commercial findByName(String commercial_name);

}
