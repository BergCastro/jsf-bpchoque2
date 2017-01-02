package br.com.fireware.bpchoque.controller;



import org.springframework.stereotype.Controller;



@Controller
public class NavBarController {


	public String patentes(){
		
		return "patentes?faces-redirect=true";
		
	}
	

}
