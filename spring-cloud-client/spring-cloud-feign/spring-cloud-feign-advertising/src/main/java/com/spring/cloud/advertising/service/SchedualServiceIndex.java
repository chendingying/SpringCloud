package com.spring.cloud.advertising.service;


import com.spring.cloud.advertising.service.impl.SchedualServiceIndexImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVICE-ADVERTISING",fallback = SchedualServiceIndexImpl.class)
public interface SchedualServiceIndex {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    String index();

    @RequestMapping(value = "/admin/login",method = RequestMethod.GET)
    String login();

    @RequestMapping(value = "/admin/login",method = RequestMethod.POST)
    String login(@RequestParam("username") String username, @RequestParam("password") String password);

    @RequestMapping(value = { "/admin/logout" }, method = RequestMethod.GET)
    String logout();
}
