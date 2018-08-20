package com.spring.cloud.advertising.controller.admin.system;

import com.spring.cloud.advertising.common.JsonResult;
import com.spring.cloud.advertising.controller.BaseController;
import com.spring.cloud.advertising.entity.Commercial;
import com.spring.cloud.advertising.entity.News;
import com.spring.cloud.advertising.entity.PointRule;
import com.spring.cloud.advertising.service.ICommercialService;
import com.spring.cloud.advertising.service.INewsService;
import com.spring.cloud.advertising.service.IPointRuleService;
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
@RequestMapping("/admin/news")
public class NewsController extends BaseController {
	@Autowired
	private INewsService newsService;

    @Autowired
	private ICommercialService commercialService;

	@Autowired
	private IPointRuleService pointRuleService;
	

	@RequestMapping("/index")
	public String index() {
		return "admin/news/index";
	}

	@RequestMapping("/list")
	@ResponseBody
	public Page<News> list() {
		SimpleSpecificationBuilder<News> builder = new SimpleSpecificationBuilder<News>();

		//过滤已删除新闻
		//
		builder.add("delete_flag", Operator.eq.name(), "0");
		builder.add("news_type", Operator.eq.name(), "1");

		String searchText = request.getParameter("searchText");
		if(StringUtils.isNotBlank(searchText)){
			builder.add("news_title", Operator.likeAll.name(), searchText);
		}
		Page<News> page = newsService.findAll(builder.generateSpecification(),getPageRequest());
		return page;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap map) {

        SimpleSpecificationBuilder<Commercial> builder = new SimpleSpecificationBuilder<Commercial>();
        builder.add("commercial_type", Operator.eq.name(), "1");
		Sort sort=new Sort(Sort.Direction.DESC,"createtime");//createTime排序
		List<Commercial> commercial = commercialService.findList(builder.generateSpecification(),sort);
		map.put("commercial", commercial);

		SimpleSpecificationBuilder<PointRule> builder2 = new SimpleSpecificationBuilder<PointRule>();
		builder2.add("delete_flag", Operator.eq.name(), "0");
		Sort sort2=new Sort(Sort.Direction.DESC,"createtime");//createTime排序
		List<PointRule> pointRules = pointRuleService.findList(builder2.generateSpecification(),sort2);
		map.put("pointRules", pointRules);
		return "admin/news/form";
	}
	

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id,ModelMap map) {
		News news = newsService.find(id);
		map.put("news", news);

		SimpleSpecificationBuilder<Commercial> builder = new SimpleSpecificationBuilder<Commercial>();
		builder.add("commercial_type", Operator.eq.name(), "1");
		Sort sort=new Sort(Sort.Direction.DESC,"createtime");//createTime排序
		List<Commercial> commercial = commercialService.findList(builder.generateSpecification(),sort);
		map.put("commercial", commercial);

		SimpleSpecificationBuilder<PointRule> builder2 = new SimpleSpecificationBuilder<PointRule>();
		builder2.add("delete_flag", Operator.eq.name(), "0");
		Sort sort2=new Sort(Sort.Direction.DESC,"createtime");//createTime排序
		List<PointRule> pointRules = pointRuleService.findList(builder2.generateSpecification(),sort2);
		map.put("pointRules", pointRules);

		return "admin/news/form";
	}
	
	@RequestMapping(value= {"/edit"}, method = RequestMethod.POST)
	@ResponseBody
	public JsonResult edit(News news, ModelMap map){
		try {
			newsService.saveOrUpdate(news);
		} catch (Exception e) {
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@PathVariable Integer id,ModelMap map) {
		try {
			newsService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}



















	@RequestMapping("/index2")
	public String index2() {
		return "admin/news/index2";
	}

	@RequestMapping("/list2")
	@ResponseBody
	public Page<News> list2() {
		SimpleSpecificationBuilder<News> builder = new SimpleSpecificationBuilder<News>();

		//过滤已删除新闻
		//
		builder.add("delete_flag", Operator.eq.name(), "0");
		builder.add("news_type", Operator.eq.name(), "2");

		String searchText = request.getParameter("searchText");
		if(StringUtils.isNotBlank(searchText)){
			builder.add("news_title", Operator.likeAll.name(), searchText);
		}
		Page<News> page = newsService.findAll(builder.generateSpecification(),getPageRequest());
		return page;
	}

	@RequestMapping(value = "/add2", method = RequestMethod.GET)
	public String add2(ModelMap map) {

		SimpleSpecificationBuilder<Commercial> builder = new SimpleSpecificationBuilder<Commercial>();
		builder.add("commercial_type", Operator.eq.name(), "2");
		Sort sort=new Sort(Sort.Direction.DESC,"createtime");//createTime排序
		List<Commercial> commercial = commercialService.findList(builder.generateSpecification(),sort);
		map.put("commercial", commercial);

		SimpleSpecificationBuilder<PointRule> builder2 = new SimpleSpecificationBuilder<PointRule>();
		builder2.add("delete_flag", Operator.eq.name(), "0");
		Sort sort2=new Sort(Sort.Direction.DESC,"createtime");//createTime排序
		List<PointRule> pointRules = pointRuleService.findList(builder2.generateSpecification(),sort2);
		map.put("pointRules", pointRules);
		return "admin/news/form2";
	}


	@RequestMapping(value = "/edit2/{id}", method = RequestMethod.GET)
	public String edit2(@PathVariable Integer id,ModelMap map) {
		News news = newsService.find(id);
		map.put("news", news);

		SimpleSpecificationBuilder<Commercial> builder = new SimpleSpecificationBuilder<Commercial>();
		builder.add("commercial_type", Operator.eq.name(), "2");
		Sort sort=new Sort(Sort.Direction.DESC,"createtime");//createTime排序
		List<Commercial> commercial = commercialService.findList(builder.generateSpecification(),sort);
		map.put("commercial", commercial);

		SimpleSpecificationBuilder<PointRule> builder2 = new SimpleSpecificationBuilder<PointRule>();
		builder2.add("delete_flag", Operator.eq.name(), "0");
		Sort sort2=new Sort(Sort.Direction.DESC,"createtime");//createTime排序
		List<PointRule> pointRules = pointRuleService.findList(builder2.generateSpecification(),sort2);
		map.put("pointRules", pointRules);

		return "admin/news/form2";
	}

	@RequestMapping(value= {"/edit2"}, method = RequestMethod.POST)
	@ResponseBody
	public JsonResult edit2(News news,ModelMap map){
		try {
			newsService.saveOrUpdate(news);
		} catch (Exception e) {
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}

	@RequestMapping(value = "/delete2/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete2(@PathVariable Integer id,ModelMap map) {
		try {
			newsService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}




















	@RequestMapping("/index3")
	public String index3() {
		return "admin/news/index3";
	}

	@RequestMapping("/list3")
	@ResponseBody
	public Page<News> list3() {
		SimpleSpecificationBuilder<News> builder = new SimpleSpecificationBuilder<News>();

		//过滤已删除新闻
		//
		builder.add("delete_flag", Operator.eq.name(), "0");
		builder.add("news_type", Operator.eq.name(), "3");

		String searchText = request.getParameter("searchText");
		if(StringUtils.isNotBlank(searchText)){
			builder.add("news_title", Operator.likeAll.name(), searchText);
		}
		Page<News> page = newsService.findAll(builder.generateSpecification(),getPageRequest());
		return page;
	}

	@RequestMapping(value = "/add3", method = RequestMethod.GET)
	public String add3(ModelMap map) {

		SimpleSpecificationBuilder<Commercial> builder = new SimpleSpecificationBuilder<Commercial>();
		builder.add("commercial_type", Operator.eq.name(), "3");
		Sort sort=new Sort(Sort.Direction.DESC,"createtime");//createTime排序
		List<Commercial> commercial = commercialService.findList(builder.generateSpecification(),sort);
		map.put("commercial", commercial);

		SimpleSpecificationBuilder<PointRule> builder2 = new SimpleSpecificationBuilder<PointRule>();
		builder2.add("delete_flag", Operator.eq.name(), "0");
		Sort sort2=new Sort(Sort.Direction.DESC,"createtime");//createTime排序
		List<PointRule> pointRules = pointRuleService.findList(builder2.generateSpecification(),sort2);
		map.put("pointRules", pointRules);
		return "admin/news/form3";
	}


	@RequestMapping(value = "/edit3/{id}", method = RequestMethod.GET)
	public String edit3(@PathVariable Integer id,ModelMap map) {
		News news = newsService.find(id);
		map.put("news", news);

		SimpleSpecificationBuilder<Commercial> builder = new SimpleSpecificationBuilder<Commercial>();
		builder.add("commercial_type", Operator.eq.name(), "3");
		Sort sort=new Sort(Sort.Direction.DESC,"createtime");//createTime排序
		List<Commercial> commercial = commercialService.findList(builder.generateSpecification(),sort);
		map.put("commercial", commercial);

		SimpleSpecificationBuilder<PointRule> builder2 = new SimpleSpecificationBuilder<PointRule>();
		builder2.add("delete_flag", Operator.eq.name(), "0");
		Sort sort2=new Sort(Sort.Direction.DESC,"createtime");//createTime排序
		List<PointRule> pointRules = pointRuleService.findList(builder2.generateSpecification(),sort2);
		map.put("pointRules", pointRules);

		return "admin/news/form3";
	}

	@RequestMapping(value= {"/edit3"}, method = RequestMethod.POST)
	@ResponseBody
	public JsonResult edit3(News news,ModelMap map){
		try {
			newsService.saveOrUpdate(news);
		} catch (Exception e) {
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}

	@RequestMapping(value = "/delete3/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete3(@PathVariable Integer id,ModelMap map) {
		try {
			newsService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}
}
