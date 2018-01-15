package com.exqoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exqoo.entity.SysFileSort;
import com.exqoo.service.SysFileSortService;

/**
 * 文件类别控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/fileSort")
public class SysFileSortController {
	
	@Autowired
	private SysFileSortService sysFileSortService;
	
	/**
	 * 查询所有的标题
	 * @return
	 */
	@RequestMapping("/select")
	public String load(){
		List<SysFileSort> list=sysFileSortService.selectAll();
		for (SysFileSort sysFileSort : list) {
			System.out.println(sysFileSort.getSortName());
		}
		return null;
	}
	

	/**
	 * 新增类别
	 * @param sysFileSort
	 * @return
	 */
	@RequestMapping("/insert")
	public String add(SysFileSort sysFileSort) {
		int a=sysFileSortService.add(sysFileSort);
		if(a>0) {
			return "forward:/index";
		}
		return "forward:/index";
	}
	
	/**
	 * 根据主键查询单行数据
	 * @param id
	 * @return
	 */
	@RequestMapping("/selectByKey")
	public ModelAndView selectByPrimaryKey(@RequestParam("id") int id) {
		SysFileSort sysFileSort =sysFileSortService.selectByPrimaryKey(id);
		ModelAndView mav=new ModelAndView();
		mav.addObject("sysFileSort",sysFileSort);
		mav.setViewName("toupdate");
		return mav;
	}
	
	/**
	 * 修改
	 * @param sysFileSort
	 * @return
	 */
	@RequestMapping("/update")
	public String update(SysFileSort sysFileSort) {
		int a =sysFileSortService.update(sysFileSort);
		return "forward:/index";
	}
	
	
	
}
