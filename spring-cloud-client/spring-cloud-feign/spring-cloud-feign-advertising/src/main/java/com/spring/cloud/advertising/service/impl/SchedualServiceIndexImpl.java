package com.spring.cloud.advertising.service.impl;

import com.spring.cloud.advertising.service.SchedualServiceIndex;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceIndexImpl implements SchedualServiceIndex {
    @Override
    public String index() {
        return "sorry"+"index ";
    }

    @Override
    public String login(){return "sorry"+"admin/login";}

    @Override
    public String login(String username, String password){
        return "sorry"+"admin/login";
    }

    @Override
    public String logout(){return "sorry"+"admin/logout";}
}


