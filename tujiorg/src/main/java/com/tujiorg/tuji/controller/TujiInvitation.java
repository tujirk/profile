package com.tujiorg.tuji.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tujiorg.tuji.db.entities.User;
import com.tujiorg.tuji.db.services.UserService;

@Controller
public class TujiInvitation {
	@Autowired
	private UserService userServices;
	
	@Autowired
	AuthenticationManager authManager;
	
	@GetMapping("/")
	public String tujiHome(Model model) {
		return "jsp/tuji/home";
	}
	
	@GetMapping("/login")
	public String loginUserGet(HttpServletRequest request) {
		return "html/tuji/login";
	}
	
	@PostMapping("/login") 
	public ModelAndView loginUserPost(HttpServletRequest request, User user) {
		ModelAndView model = new ModelAndView();
		UsernamePasswordAuthenticationToken token= 
				new UsernamePasswordAuthenticationToken(user.getUserID(), user.getPassword());
		try {
			Authentication authentication = authManager.authenticate(token);
			SecurityContext sc= SecurityContextHolder.getContext();
			sc.setAuthentication(authentication);
			if(sc.getAuthentication().isAuthenticated()) {
				System.out.println("Done");
			}
			model.setViewName("redirect:/profile");
		} catch(Exception e) {
			model.addObject("error", "-1");
			model.setViewName("redirect:/login");
		}
		return model;
	}
	
	@PostMapping("/register")
	public ModelAndView registerUser(User user) {
		String view="html/tuji/login";
		String error=null;
		if(!user.getUserID().trim().isEmpty()) {
			if(!isUserExist(user.getUserID())) {
				userServices.saveUser(user);
				view="redirect:/profile";
			} else {
				error="1";
			}
		} else {
			error="0";
		}

		ModelAndView model= new ModelAndView(view);
		if(error!=null) model.addObject("error", error);
		return model;
	}
	
	@ResponseBody
	@PostMapping("/isUserExist")
	public boolean isUserExist(@RequestBody String userId) {
		return userServices.isUserExist(userId.substring(userId.indexOf('=')+1 ) );
	}
	
}
