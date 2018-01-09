package com.exqoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exqoo.entity.SysFileSort;
import com.exqoo.service.SysFileSortService;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/aaa")
public class SysFileSortController {
	
	@Autowired
	private SysFileSortService sysFileSortService;
	
	@RequestMapping("/bbb")
	public String load(){
		List<SysFileSort> list=sysFileSortService.selectAll();
		for (SysFileSort sysFileSort : list) {
			System.out.println(sysFileSort.getSortName());
		}
		return null;
	}
}
