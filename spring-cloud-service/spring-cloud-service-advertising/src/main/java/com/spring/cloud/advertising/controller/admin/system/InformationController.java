package com.spring.cloud.advertising.controller.admin.system;

import com.spring.cloud.advertising.common.JsonResult;
import com.spring.cloud.advertising.controller.BaseController;
import com.spring.cloud.advertising.entity.Commercial;
import com.spring.cloud.advertising.entity.Information;
import com.spring.cloud.advertising.service.ICommercialService;
import com.spring.cloud.advertising.service.IInformationService;
import com.spring.cloud.advertising.service.specification.SimpleSpecificationBuilder;
import com.spring.cloud.advertising.service.specification.SpecificationOperator.Operator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/information")
public class InformationController extends BaseController {

	@Autowired
	private IInformationService informationService;

	@Autowired
	private ICommercialService commercialService;

	@RequestMapping("/index")
	public String index() {
		return "admin/information/index";
	}

	@RequestMapping("/list")
	@ResponseBody
	public Page<Information> list() {
		SimpleSpecificationBuilder<Information> builder = new SimpleSpecificationBuilder<Information>();
		String searchText = request.getParameter("searchText");
		if(StringUtils.isNotBlank(searchText)){
			builder.add("information_title", Operator.likeAll.name(), searchText);
		}
		Page<Information> page = informationService.findAll(builder.generateSpecification(),getPageRequest());
		return page;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap map) {

		SimpleSpecificationBuilder<Commercial> builder = new SimpleSpecificationBuilder<Commercial>();
		builder.add("commercial_type", Operator.eq.name(), "0");
		Sort sort=new Sort(Sort.Direction.DESC,"createtime");//createTime排序
		List<Commercial> commercial = commercialService.findList(builder.generateSpecification(),sort);
		map.put("commercial", commercial);
		return "admin/information/form";
	}
	

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id,ModelMap map) {
		Information information = informationService.find(id);
		map.put("information", information);

		SimpleSpecificationBuilder<Commercial> builder = new SimpleSpecificationBuilder<Commercial>();
		builder.add("commercial_type", Operator.eq.name(), "0");
		Sort sort=new Sort(Sort.Direction.DESC,"createtime");//createTime排序
		List<Commercial> commercial = commercialService.findList(builder.generateSpecification(),sort);
		map.put("commercial", commercial);
		return "admin/information/form";
	}
	
	@RequestMapping(value= {"/edit"}, method = RequestMethod.POST)
	@ResponseBody
	public JsonResult edit(Information information, ModelMap map){
		try {
			informationService.saveOrUpdate(information);
		} catch (Exception e) {
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@PathVariable Integer id,ModelMap map) {
		try {
			informationService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
}
