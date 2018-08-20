package com.spring.cloud.advertising.web;

import com.spring.cloud.advertising.service.SchedualServiceNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class NewsController {
    @Autowired
    SchedualServiceNews schedualServiceNews;

    @Autowired
    HttpServletRequest httpServletRequest;

    @RequestMapping("/admin/news/index")
    public String index() {
        return schedualServiceNews.index();
    }

    @RequestMapping("/admin/news/list")
    public String list(){
        String sortOrder = httpServletRequest.getParameter("sortOrder");
        System.out.println(sortOrder);
        return schedualServiceNews.list();
    }


    @RequestMapping("/admin/news/add")
    public String add(){return schedualServiceNews.add();}


    @RequestMapping("/admin/news/edit")
    public String edit(){return schedualServiceNews.edit();}

    @RequestMapping("/admin/news/edit/{id}")
    public String edit(@PathVariable Integer id){return schedualServiceNews.edit(id);}

    @RequestMapping("/admin/news/delete/{id}")
    public String delete(@PathVariable Integer id){return schedualServiceNews.delete(id);}


    @RequestMapping("/admin/news/index2")
    public String index2(){return schedualServiceNews.index2();}


    @RequestMapping("/admin/news/list2")
    public String list2(){return schedualServiceNews.list2();}


    @RequestMapping("/admin/news/add2")
    public String add2(){return schedualServiceNews.add2();}


    @RequestMapping("/admin/news/edit2")
    public String edit2(){return schedualServiceNews.edit2();}

    @RequestMapping("/admin/news/edit2/{id}")
    public String edit2(@PathVariable Integer id){return schedualServiceNews.edit2(id);}

    @RequestMapping("/admin/news/delete2/{id}")
    public String delete2(@PathVariable Integer id){return schedualServiceNews.delete2(id);}



    @RequestMapping("/admin/news/index3")
    public String index3(){return schedualServiceNews.index3();}


    @RequestMapping("/admin/news/list3")
    public String list3(){return schedualServiceNews.list3();}


    @RequestMapping("/admin/news/add3")
    public String add3(){return schedualServiceNews.add3();}


    @RequestMapping("/admin/news/edit3")
    public String edit3(){return schedualServiceNews.edit3();}

    @RequestMapping("/admin/news/edit3/{id}")
    public String edit3(@PathVariable Integer id){return schedualServiceNews.edit3(id);}

    @RequestMapping("/admin/news/delete3/{id}")
    public String delete3(@PathVariable Integer id){return schedualServiceNews.delete3(id);}
}
