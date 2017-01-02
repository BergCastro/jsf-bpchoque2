package br.com.fireware.bpchoque.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = {"/", "", "/index"})
	public ModelAndView root() {
		return new ModelAndView("/home");

	}
	
	@RequestMapping(value = {"/erro"})
	public ModelAndView error() {
		return new ModelAndView("/erro");
	}
	
	
	
	

	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public ModelAndView userHome() {
		return new ModelAndView("/user/index");

	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("/public/index");

	}
	
	
	
	
	
	@RequestMapping(value = "/public/login")
	public ModelAndView publicLogin() {
		return new ModelAndView("public/login");

	}
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ModelAndView logout() {
		return new ModelAndView("public/login");

	}
	@RequestMapping(value="/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "/public/login";
	}
	


}
