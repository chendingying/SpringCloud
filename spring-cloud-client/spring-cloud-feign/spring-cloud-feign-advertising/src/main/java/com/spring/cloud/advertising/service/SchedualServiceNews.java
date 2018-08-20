package com.spring.cloud.advertising.service;


import com.spring.cloud.advertising.service.impl.SchedualServiceNewsImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@FeignClient(value = "SERVICE-ADVERTISING",fallback = SchedualServiceNewsImpl.class)
public interface SchedualServiceNews {

    String url = "/admin/news";

    @RequestMapping(url+"/index")
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


    @RequestMapping(url+"/index2")
    String index2();

    @RequestMapping(url+"/list2")
    String list2();

    @RequestMapping(url+"/add2")
    String add2();

    @RequestMapping(value = url+"/edit2",method = RequestMethod.POST)
    String edit2();

    @RequestMapping(url+"/edit2/{id}")
    String edit2(@PathVariable("id") Integer id);

    @RequestMapping(value = url+"/delete2/{id}",method = RequestMethod.POST)
    String delete2(@PathVariable("id") Integer id);


    @RequestMapping(url+"/index3")
    String index3();

    @RequestMapping(url+"/list3")
    String list3();

    @RequestMapping(url+"/add3")
    String add3();

    @RequestMapping(value = url+"/edit3",method = RequestMethod.POST)
    String edit3();

    @RequestMapping(url+"/edit3/{id}")
    String edit3(@PathVariable("id") Integer id);

    @RequestMapping(value = url+"/delete3/{id}",method = RequestMethod.POST)
    String delete3(@PathVariable("id") Integer id);
}
