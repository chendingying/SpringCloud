package com.spring.cloud.advertising.web;


import com.spring.cloud.advertising.service.SchedualServiceAdminIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminIndexController {

	@Autowired
	SchedualServiceAdminIndex schedualServiceAdminIndex;

	@RequestMapping(value ={"/admin/index"})
	public String index(){

		return schedualServiceAdminIndex.index();
	}

	@RequestMapping(value = {"/admin/welcome"})
	public String welcome(){

		return schedualServiceAdminIndex.welcome();
	}
}
