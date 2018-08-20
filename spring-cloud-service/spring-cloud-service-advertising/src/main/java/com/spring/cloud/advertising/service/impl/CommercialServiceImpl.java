package com.spring.cloud.advertising.service.impl;

import com.spring.cloud.advertising.dao.ICommercialDao;
import com.spring.cloud.advertising.dao.support.IBaseDao;
import com.spring.cloud.advertising.entity.Commercial;
import com.spring.cloud.advertising.service.ICommercialService;
import com.spring.cloud.advertising.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账户表  服务实现类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Service
public class CommercialServiceImpl extends BaseServiceImpl<Commercial, Integer> implements ICommercialService {

    @Autowired
    private ICommercialDao commercialDao;


    @Override
    public IBaseDao<Commercial, Integer> getBaseDao() {
        return this.commercialDao;
    }

//    @Override
//    public Commercial findByName(String username) {
//        return commercialDao.findByName(username);
//    }

    @Override
    public void saveOrUpdate(Commercial commercial) {
        if(commercial.getId() != null){
            Commercial dbcmmercial = find(commercial.getId());
            dbcmmercial.setName(commercial.getName());
            dbcmmercial.setPicture(commercial.getPicture());
            dbcmmercial.setType(commercial.getType());
            dbcmmercial.setWebsite(commercial.getWebsite());
            dbcmmercial.setTime(commercial.getTime());
            update(dbcmmercial);
        }else{
            commercial.setType(commercial.getType());
            commercial.setName(commercial.getName());
            commercial.setPicture(commercial.getPicture());
            commercial.setType(commercial.getType());
            commercial.setWebsite(commercial.getWebsite());
            //commercial.setTime((int)System.currentTimeMillis());
            commercial.setTime((int)(System.currentTimeMillis()/1000));
            save(commercial);
        }
    }



    @Override
    public void delete(Integer id) {
        //Commercial commercial = find(id);
        super.delete(id);
    }

}
