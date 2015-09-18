package org.theme.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.codec.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.theme.entity.User;
import org.theme.web.service.UserService;

@Controller
@RequestMapping(value = "/security")
public class AccountController {

	@Autowired
	private UserService userService;
	 
	@RequestMapping(value = "/user",method = RequestMethod.GET)
	public String findUser(@RequestParam(name = "id") long id,Model model){
		User user = userService.getUser(id);
		model.addAttribute("user",user);
		return "user/detail";
	}
	
	@RequestMapping(value = "/reg",method = RequestMethod.POST)
	public String reg(HttpServletRequest req) throws UnsupportedEncodingException{
		String loginName = req.getParameter("loginName");
		String name = req.getParameter("name");
		String password = req.getParameter("loginName");
		User user = new User();
		user.setLoginName(loginName);
		user.setName(name);
		user.setPassword(password);
		user.setSalt(Hex.encodeToString(name.getBytes("utf-8")));
		user.setRoles("user");
		user.setRegisterDate(new Date());
		userService.save(user);
		return "account/result";
	}
	
	@RequestMapping(value = "/reg",method = RequestMethod.GET)
	public String reg(){
		return "account/reg";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(){
		return "account/login";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(HttpServletRequest req){
		return "account/login";
	}
}
