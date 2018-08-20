package com.spring.cloud.advertising.web;

import com.spring.cloud.advertising.service.SchedualServiceAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {
    @Autowired
    SchedualServiceAccount schedualServiceAccount;

    @RequestMapping(value = "/admin/account/index",method = RequestMethod.GET)
    public String index(){return schedualServiceAccount.index();}

    @RequestMapping("/admin/account/list")
    public String list(){return schedualServiceAccount.list();}

    @RequestMapping("/admin/account/add")
    public String add(){return schedualServiceAccount.add();}

    @RequestMapping("/admin/account/edit")
    public String edit(){return schedualServiceAccount.edit();}

    @RequestMapping("/admin/account/edit/{id}")
    public String edit(@PathVariable Integer id){return schedualServiceAccount.edit(id);}

    @RequestMapping("/admin/account/delete/{id}")
    public String delete(@PathVariable Integer id){return schedualServiceAccount.delete(id);}
}
