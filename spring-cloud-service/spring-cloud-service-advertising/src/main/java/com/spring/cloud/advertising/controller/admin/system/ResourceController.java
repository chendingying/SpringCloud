package com.spring.cloud.advertising.controller.admin.system;

import com.spring.cloud.advertising.common.JsonResult;
import com.spring.cloud.advertising.controller.BaseController;
import com.spring.cloud.advertising.entity.Resource;
import com.spring.cloud.advertising.service.IResourceService;
import com.spring.cloud.advertising.service.specification.SimpleSpecificationBuilder;
import com.spring.cloud.advertising.vo.ZtreeView;
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
@RequestMapping("/admin/resource")
public class ResourceController extends BaseController {
	@Autowired
	private IResourceService resourceService;
	
	@RequestMapping("/tree/{resourceId}")
	@ResponseBody
	public List<ZtreeView> tree(@PathVariable Integer resourceId){
		List<ZtreeView> list = resourceService.tree(resourceId);
		return list;
	}
	
	@RequestMapping("/index")
	public String index() {
		return "admin/resource/index";
	}

	@RequestMapping("/list")
	@ResponseBody
	public Page<Resource> list() {
		SimpleSpecificationBuilder<Resource> builder = new SimpleSpecificationBuilder<Resource>();
		String searchText = request.getParameter("searchText");
		if(StringUtils.isNotBlank(searchText)){
			builder.add("name", Operator.likeAll.name(), searchText);
		}
		Page<Resource> page = resourceService.findAll(builder.generateSpecification(),getPageRequest());
		return page;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap map) {
		List<Resource> list = resourceService.findAll();
		map.put("list", list);
		return "admin/resource/form";
	}
	

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id,ModelMap map) {
		Resource resource = resourceService.find(id);
		map.put("resource", resource);
		
		List<Resource> list = resourceService.findAll();
		map.put("list", list);
		return "admin/resource/form";
	}
	
	@RequestMapping(value= {"/edit"}, method = RequestMethod.POST)
	@ResponseBody
	public JsonResult edit(Resource resource, ModelMap map){
		try {
			resourceService.saveOrUpdate(resource);
		} catch (Exception e) {
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@PathVariable Integer id,ModelMap map) {
		try {
			resourceService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
}
