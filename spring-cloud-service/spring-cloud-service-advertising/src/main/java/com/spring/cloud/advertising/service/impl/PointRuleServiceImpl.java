package com.spring.cloud.advertising.service.impl;

import com.spring.cloud.advertising.dao.IPointRuleDao;
import com.spring.cloud.advertising.dao.support.IBaseDao;
import com.spring.cloud.advertising.entity.PointRule;
import com.spring.cloud.advertising.service.IPointRuleService;
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
public class PointRuleServiceImpl extends BaseServiceImpl<PointRule, Integer> implements IPointRuleService {

    @Autowired
    private IPointRuleDao pointRuleDao;


    @Override
    public IBaseDao<PointRule, Integer> getBaseDao() {
        return this.pointRuleDao;
    }

//    @Override
//    public Commercial findByName(String username) {
//        return commercialDao.findByName(username);
//    }

    @Override
    public void saveOrUpdate(PointRule pointRule) {
        if(pointRule.getPoint_rule_id() != null){
            PointRule dbpointrule = find(pointRule.getPoint_rule_id());
            dbpointrule.setName(pointRule.getName());
            dbpointrule.setPoint(pointRule.getPoint());
            dbpointrule.setTime(pointRule.getTime());
            dbpointrule.setTimeout(pointRule.getTimeout());
            dbpointrule.setGet_count(pointRule.getGet_count());
            //dbpointrule.setDelete_flag(pointRule.getDelete_flag());
            //dbpointrule.setCreatetime(pointRule.getCreatetime());
            update(dbpointrule);
        }else{
            pointRule.setName(pointRule.getName());
            pointRule.setPoint(pointRule.getPoint());
            pointRule.setTime(pointRule.getTime());
            pointRule.setTimeout(pointRule.getTimeout());
            pointRule.setGet_count(pointRule.getGet_count());
            pointRule.setDelete_flag(0);
            pointRule.setCreatetime((int)(System.currentTimeMillis()/1000));
            save(pointRule);
        }
    }



    @Override
    public void delete(Integer id) {
        //Commercial commercial = find(id);
        //super.delete(id);

        //逻辑删
        //
        PointRule pointRule=find(id);
        pointRule.setDelete_flag(1);
        update(pointRule);
    }

}
