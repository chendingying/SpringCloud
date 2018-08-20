package com.spring.cloud.advertising.service.impl;

import com.spring.cloud.advertising.dao.IInformationDao;
import com.spring.cloud.advertising.dao.support.IBaseDao;
import com.spring.cloud.advertising.entity.Information;
import com.spring.cloud.advertising.service.IInformationService;
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
public class InformationServiceImpl extends BaseServiceImpl<Information, Integer> implements IInformationService {

    @Autowired
    private IInformationDao informationDao;


    @Override
    public IBaseDao<Information, Integer> getBaseDao() {
        return this.informationDao;
    }

//    @Override
//    public Commercial findByName(String username) {
//        return commercialDao.findByName(username);
//    }

    @Override
    public void saveOrUpdate(Information information) {
        if(information.getInformation_id() != null){
            Information dbinformation = find(information.getInformation_id());
            dbinformation.setCommercial_id(information.getCommercial_id());
            dbinformation.setInformation_title(information.getInformation_title());
            dbinformation.setInformation_content(information.getInformation_content());
            dbinformation.setLike_count(information.getLike_count());
            //dbinformation.setCreatetime(information.getCreatetime());
            update(dbinformation);
        }else{
            information.setCommercial_id(information.getCommercial_id());
            information.setInformation_title(information.getInformation_title());
            information.setInformation_content(information.getInformation_content());
            information.setLike_count(information.getLike_count());
            information.setCreatetime((int)(System.currentTimeMillis()/1000));
            save(information);
        }
    }



    @Override
    public void delete(Integer id) {
        //Commercial commercial = find(id);
        super.delete(id);
    }

}
