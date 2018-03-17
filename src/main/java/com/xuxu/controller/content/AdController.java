package com.xuxu.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xuxu.controller.PageCodeEnum;
import com.xuxu.dto.AdDto;
import com.xuxu.service.AdService;

@Controller
@RequestMapping("/ad")
public class AdController {
	@Autowired
	private AdService adService;
	
	@RequestMapping
	public String init(){
		return "/content/adList";
	}
	
	@RequestMapping("/addInit")
	public String addInit(){
		return "/content/adAdd";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(AdDto adDto,Model model){
		if(adService.insert(adDto)){
			model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.ADD_SUCCESS);
		}else{
			model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.ADD_FAIL);
		}
		return "/content/adAdd";
	}
}
