package com.spring.cloud.advertising.web;

import com.spring.cloud.advertising.service.SchedualServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    SchedualServiceUser schedualServiceUser;

    @RequestMapping("/admin/user/index")
    public String index(){return schedualServiceUser.index();}


    @RequestMapping("/admin/user/list")
    public String list(){return schedualServiceUser.list();}


    @RequestMapping("/admin/user/add")
    public String add(){return schedualServiceUser.add();}


    @RequestMapping("/admin/user/edit")
    public String edit(){return schedualServiceUser.edit();}

    @RequestMapping("/admin/user/edit/{id}")
    public String edit(@PathVariable Integer id){return schedualServiceUser.edit(id);}

    @RequestMapping("/admin/user/delete/{id}")
    public String delete(@PathVariable Integer id){return schedualServiceUser.delete(id);}

    @RequestMapping("/admin/user/grant/{id}")
    public String grant(@PathVariable Integer id) {
        return schedualServiceUser.grant(id);
    }
}
