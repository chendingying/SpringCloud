package com.spring.cloud.advertising.web;

import com.spring.cloud.advertising.service.SchedualServiceRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RoleController {
    @Autowired
    SchedualServiceRole schedualServiceRole;

    @RequestMapping("/admin/role/index")
    public String index(){return schedualServiceRole.index();}


    @RequestMapping("/admin/role/list")
    public String list(){return schedualServiceRole.list();}


    @RequestMapping("/admin/role/add")
    public String add(){return schedualServiceRole.add();}


    @RequestMapping("/admin/role/edit")
    public String edit(){return schedualServiceRole.edit();}

    @RequestMapping("/admin/role/edit/{id}")
    public String edit(@PathVariable Integer id){return schedualServiceRole.edit(id);}

    @RequestMapping("/admin/role/delete/{id}")
    public String delete(@PathVariable Integer id){return schedualServiceRole.delete(id);}
}
