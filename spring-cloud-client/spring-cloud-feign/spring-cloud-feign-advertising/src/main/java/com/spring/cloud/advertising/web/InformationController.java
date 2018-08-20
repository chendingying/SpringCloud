package com.spring.cloud.advertising.web;

import com.spring.cloud.advertising.service.SchedualServiceInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InformationController {
    @Autowired
    SchedualServiceInformation schedualServiceInformation;
    @RequestMapping("/admin/information/index")
    public String index(){return schedualServiceInformation.index();}

    @RequestMapping("/admin/information/list")
    public String list(){return schedualServiceInformation.list();}

    @RequestMapping("/admin/information/add")
    public String add(){return schedualServiceInformation.add();}

    @RequestMapping("/admin/information/edit")
    public String edit(){return schedualServiceInformation.edit();}

    @RequestMapping("/admin/information/edit/{id}")
    public String edit(@PathVariable Integer id){return schedualServiceInformation.edit(id);}

    @RequestMapping("/admin/information/delete/{id}")
    public String delete(@PathVariable Integer id){return schedualServiceInformation.delete(id);}
}
