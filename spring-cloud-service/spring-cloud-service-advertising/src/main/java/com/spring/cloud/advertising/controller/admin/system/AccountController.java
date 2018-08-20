package com.spring.cloud.advertising.controller.admin.system;

import com.spring.cloud.advertising.common.JsonResult;
import com.spring.cloud.advertising.controller.BaseController;
import com.spring.cloud.advertising.entity.Account;
import com.spring.cloud.advertising.service.IAccountService;
import com.spring.cloud.advertising.service.specification.SimpleSpecificationBuilder;
import com.spring.cloud.advertising.service.specification.SpecificationOperator.Operator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/account")
public class AccountController extends BaseController {
	@Autowired
	private IAccountService accountService;
	

	@RequestMapping("/index")
	public String index() {
		return "admin/account/index";
	}

	@RequestMapping("/list")
	@ResponseBody
	public Page<Account> list() {
		SimpleSpecificationBuilder<Account> builder = new SimpleSpecificationBuilder<Account>();

		//过滤已删除
		//
		builder.add("is_delete", Operator.eq.name(), "0");


		String searchText = request.getParameter("searchText");
		if(StringUtils.isNotBlank(searchText)){
			builder.add("nick_name", Operator.likeAll.name(), searchText);
		}
		Page<Account> page = accountService.findAll(builder.generateSpecification(),getPageRequest());
		return page;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap map) {
		List<Account> list = accountService.findAll();
		map.put("list", list);
		return "admin/account/form";
	}
	

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id,ModelMap map) {
		Account account = accountService.find(id);
		map.put("account", account);
		
		List<Account> list = accountService.findAll();
		map.put("list", list);
		return "admin/account/form";
	}
	
	@RequestMapping(value= {"/edit"}, method = RequestMethod.POST)
	@ResponseBody
	public JsonResult edit(Account account, ModelMap map){
		try {
			accountService.saveOrUpdate(account);
		} catch (Exception e) {
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@PathVariable Integer id,ModelMap map) {
		try {
			accountService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
}
