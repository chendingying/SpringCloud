package com.spring.cloud.advertising.web;

import com.spring.cloud.advertising.service.SchedualServiceResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @Autowired
    SchedualServiceResource schedualServiceResource;

    @RequestMapping("/admin/resource/index")
    public String index(){return schedualServiceResource.index();}


    @RequestMapping("/admin/resource/list")
    public String list(){return schedualServiceResource.list();}


    @RequestMapping("/admin/resource/add")
    public String add(){return schedualServiceResource.add();}


    @RequestMapping("/admin/resource/edit")
    public String edit(){return schedualServiceResource.edit();}

    @RequestMapping("/admin/resource/edit/{id}")
    public String edit(@PathVariable Integer id){return schedualServiceResource.edit(id);}

    @RequestMapping("/admin/resource/delete/{id}")
    public String delete(@PathVariable Integer id){return schedualServiceResource.delete(id);}
}
