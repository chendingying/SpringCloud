package com.spring.cloud.advertising.service.impl;

import com.spring.cloud.advertising.dao.IAccountDao;
import com.spring.cloud.advertising.dao.support.IBaseDao;
import com.spring.cloud.advertising.entity.Account;
import com.spring.cloud.advertising.service.IAccountService;
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
public class AccountServiceImpl extends BaseServiceImpl<Account, Integer> implements IAccountService {

    @Autowired
    private IAccountDao accountDao;


    @Override
    public IBaseDao<Account, Integer> getBaseDao() {
        return this.accountDao;
    }

//    @Override
//    public Commercial findByName(String username) {
//        return commercialDao.findByName(username);
//    }

    @Override
    public void saveOrUpdate(Account account) {
        if(account.getId() != null){
            Account dbaccount = find(account.getId());
            //List<Account> list= findAll();
            dbaccount.setLogin_name(account.getLogin_name());
            dbaccount.setNick_name(account.getNick_name());
            dbaccount.setPicture_url(account.getPicture_url());
            dbaccount.setPoint(account.getPoint());
            account.setUpdatetime((int)(System.currentTimeMillis()/1000));
            update(dbaccount);
        }else{
            //account.setId(UUID.randomUUID().toString());
            account.setUser_id(account.getUser_id());
            account.setLogin_name(account.getLogin_name());
            account.setNick_name(account.getNick_name());
            account.setPicture_url(account.getPicture_url());
            account.setPoint(account.getPoint());
            account.setIs_delete(0);
            account.setUpdatetime((int)(System.currentTimeMillis()/1000));
            account.setCreatetime((int)(System.currentTimeMillis()/1000));
            save(account);
        }
    }



    @Override
    public void delete(Integer id) {
        //Commercial commercial = find(id);
        //super.delete(id);

        //逻辑删
        //
        Account account=find(id);
        account.setIs_delete(1);
        update(account);
    }

}
