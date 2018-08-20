package com.spring.cloud.advertising.web;

import com.spring.cloud.advertising.service.SchedualServicePointRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointRuleController {

    @Autowired
    SchedualServicePointRule schedualServicePointRule;

    @RequestMapping("/admin/pointrule/index")
    public String index(){return schedualServicePointRule.index();}


    @RequestMapping("/admin/pointrule/list")
    public String list(){return schedualServicePointRule.list();}


    @RequestMapping("/admin/pointrule/add")
    public String add(){return schedualServicePointRule.add();}


    @RequestMapping("/admin/pointrule/edit")
    public String edit(){return schedualServicePointRule.edit();}

    @RequestMapping("/admin/pointrule/edit/{id}")
    public String edit(@PathVariable Integer id){return schedualServicePointRule.edit(id);}

    @RequestMapping("/admin/pointrule/delete/{id}")
    public String delete(@PathVariable Integer id){return schedualServicePointRule.delete(id);}

}
