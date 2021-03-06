package com.spring.cloud.advertising.service;


import com.spring.cloud.advertising.service.impl.SchedualServiceAccountImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "SERVICE-ADVERTISING",fallback = SchedualServiceAccountImpl.class)
public interface SchedualServiceAccount {

    String url = "/admin/account";

    @RequestMapping(value = url+"/index",method = RequestMethod.GET)
    String index();

    @RequestMapping(url+"/list")
    String list();

    @RequestMapping(url+"/add")
    String add();

    @RequestMapping(value = url+"/edit",method = RequestMethod.POST)
    String edit();

    @RequestMapping(url+"/edit/{id}")
    String edit(@PathVariable("id") Integer id);

    @RequestMapping(value = url+"/delete/{id}",method = RequestMethod.POST)
    String delete(@PathVariable("id") Integer id);
}
