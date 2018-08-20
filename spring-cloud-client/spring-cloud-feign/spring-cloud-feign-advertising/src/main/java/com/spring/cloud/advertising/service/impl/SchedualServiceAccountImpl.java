package com.spring.cloud.advertising.service.impl;

import com.spring.cloud.advertising.service.SchedualServiceAccount;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;


@Component
public class SchedualServiceAccountImpl implements SchedualServiceAccount {
    @Override
    public String index(){ return "sorry";}

    @Override
    public String list(){return "sorry";}

    @Override
    public String add(){return "sorry";}

    @Override
    public String edit(){return "sorry";}

    @Override
    public String edit(@PathVariable Integer id){return "sorry";}

    @Override
    public String delete(@PathVariable Integer id){return "sorry";}
}
