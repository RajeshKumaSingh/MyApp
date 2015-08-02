package com.myapp.controller;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.form.LoginForm;
import com.myapp.service.api.LoginService;
 
@Controller
@RequestMapping("/")

public class LoginController {
	
	@Autowired private LoginService loginService;
	
	@RequestMapping(value="/dialog_login", method = RequestMethod.GET)
	public String dialog_login(@ModelAttribute("login")LoginForm loginForm) {
		return "dialog_login"; 
	}
	
	@RequestMapping(value="/submitLogin", method = RequestMethod.POST)
	public ModelAndView submitlogin(@ModelAttribute("login")LoginForm login, BindingResult result, HttpServletRequest httpReq) {
		System.out.println("Inside submit login");
		System.out.println("User Name:" + login.getUsername() + 
                "Password:" + login.getPassword());
		boolean usrLoggedIn = false;
		if(null!=httpReq.getSession().getAttribute("usrLoggedIn")){
			usrLoggedIn = (boolean) httpReq.getSession().getAttribute("usrLoggedIn");
		}	
		ModelAndView mv = new ModelAndView("home");
		httpReq.getSession().setAttribute("usrLoggedIn",usrLoggedIn);
		mv.addObject("usrLoginForm",login);
		return mv;
 
	}
	
	/*@RequestMapping(value="/submitLogin", method = RequestMethod.POST)
	public ModelAndView submitlogin(@ModelAttribute("login")LoginForm login, BindingResult result, HttpServletRequest httpReq) {
		new LoginFormValidator().validate(login, result);
		if(result.hasErrors()){
			System.out.println(result.getAllErrors());
			ModelAndView mv = new ModelAndView("dialog_login");
			return mv;
		}
		ModelAndView mv = new ModelAndView("home");
		httpReq.getSession().setAttribute("usrLoggedIn",true);
		mv.addObject("usrLoginForm",login);
		return mv;
 
	}*/
	
	
	
	@RequestMapping(value="/ajaxLogin", method = RequestMethod.POST)
	public @ResponseBody
	String ajaxlogin(@Valid @ModelAttribute("login")LoginForm login, BindingResult result, HttpServletRequest httpReq) {
		
		
		String[] otherLoginOptions = {"Facebook","Google","Yahoo"};
		
		ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
       
        StringBuilder script= new StringBuilder();
        for (String str:otherLoginOptions){
        	script = script.append("<div id=\""+str+"\">"+str+"</div>");
        }
        
        try {
			engine.eval("function foo(){ return ('"+script+"')}" );
			String s = (String) engine.eval("foo()");
			return s;
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        return "serversidevalidationfailed";
	}
	
	
	@RequestMapping("/dialog_logout")
	public String dialog_login(HttpServletRequest httpReq) {
		httpReq.getSession().setAttribute("usrLoggedIn",false);
		return "home"; 
	}
	
	@RequestMapping("/dynamic_menu")
	public String dynamic_menu(HttpServletRequest httpReq) {
		httpReq.getSession().setAttribute("usrLoggedIn",false);
		return "home"; 
	}
	
	
}
