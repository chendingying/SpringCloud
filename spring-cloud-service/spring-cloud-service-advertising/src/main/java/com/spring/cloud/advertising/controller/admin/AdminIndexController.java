package com.spring.cloud.advertising.controller.admin;

import com.spring.cloud.advertising.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminIndexController extends BaseController {

	@RequestMapping(value ={"/admin/","/admin/index"})
	public String index(){
		System.out.println("index-----------------------------------");
		return "admin/index";
	}
	
	@RequestMapping(value = {"/admin/welcome"})
	public String welcome(){
		System.out.println("welcome----------------------------------");
		return "admin/welcome";
	}
}
