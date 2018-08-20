package com.spring.cloud.advertising.web;

import com.spring.cloud.advertising.service.SchedualServiceCommercial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommercialController {
    @Autowired
    SchedualServiceCommercial schedualServiceCommercial;

    @RequestMapping("/admin/commercial/index")
    public String index(){return schedualServiceCommercial.index();}

    @RequestMapping("/admin/commercial/list")
    public String list(){return schedualServiceCommercial.list();}

    @RequestMapping("/admin/commercial/add")
    public String add(){return schedualServiceCommercial.add();}

    @RequestMapping("/admin/commercial/edit")
    public String edit(){return schedualServiceCommercial.edit();}

    @RequestMapping("/admin/commercial/edit/{id}")
    public String edit(@PathVariable Integer id){return schedualServiceCommercial.edit(id);}

    @RequestMapping("/admin/commercial/delete/{id}")
    public String delete(@PathVariable Integer id){return schedualServiceCommercial.delete(id);}
}
