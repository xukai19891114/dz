package com.xuxu.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	//初始页面
	@RequestMapping
	public String init(){
		return "/system/index";
	}
}
