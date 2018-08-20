package com.spring.cloud.advertising.web;

import com.spring.cloud.advertising.service.SchedualServiceIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    SchedualServiceIndex schedualServiceIndex;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return schedualServiceIndex.index();
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public String login() {
        return schedualServiceIndex.login();
    }

    @RequestMapping(value = "/admin/login",method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password){
        return schedualServiceIndex.login(username,password);
    }

    @RequestMapping(value = { "/admin/logout" }, method = RequestMethod.GET)
    public String logout() {
        return schedualServiceIndex.logout();
    }

}
