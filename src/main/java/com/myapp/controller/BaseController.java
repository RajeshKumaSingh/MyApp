package com.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.form.HomeForm;
 
@Controller
//@RequestMapping("/")
@SessionAttributes
public class BaseController {
	
	@RequestMapping(value={"/","/home"}, method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("form") HomeForm homeForm){
		System.out.println("Servlet 1 : ");
		ModelAndView mv = new ModelAndView("home");
		if(homeForm.getMapping()!=null){
			for(String str: homeForm.getMapping()){
				System.out.println("String value is : "+str);
			}
		}
		return mv;
	}
	
	@RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
	public ModelAndView home(@ModelAttribute("form") HomeForm homeForm, HttpServletRequest httpReq) {
		ModelAndView mv = new ModelAndView("home");
		System.out.println("Servlet 2 Get : ");
		boolean usrLoggedIn=false;
		if(null!=httpReq.getSession().getAttribute("usrLoggedIn")){
			usrLoggedIn = (boolean) httpReq.getSession().getAttribute("usrLoggedIn");
		}		
		if(!usrLoggedIn){
			httpReq.getSession().setAttribute("usrLoggedIn",false);
		}
		
		List<String> mapping = new ArrayList<String>();
		List<String> value = new ArrayList<String>();
		
		for(int i=0;i<5;i++){
			mapping.add("Data : "+i);
			value.add("value"+i);
		}
		
		homeForm.setMapping(mapping);
		homeForm.setValues(value);
		
		return mv;
 
	}
	
	@RequestMapping("/{id}/home")
	public String loginPage(@PathVariable String id) {
		System.out.println("Inside loginPage with id = "+id);
		
		return "home"; 
	}
	
	@RequestMapping("home/{s}/home")
	public String loginPage2(@PathVariable String s) {
		System.out.println("Inside loginPage with id = "+s);
		
		return "home"; 
	}
 
}