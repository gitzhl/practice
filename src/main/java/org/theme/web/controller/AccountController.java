package org.theme.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		String email = req.getParameter("email");
		User user = new User();
		user.setLoginName(loginName);
		user.setName(name);
		user.setPassword(new Md5Hash(password).toHex());
		user.setEmail(email);
		user.setSalt(Hex.encodeToString(name.getBytes("utf-8")));
		user.setRoles("user");
		user.setRegisterDate(new Date());
		userService.save(user);
		return "account/result";
	}
	
	@RequestMapping(value = "/checkLoginToken",method = RequestMethod.POST)
	@ResponseBody
	public String validateLoginName(@RequestParam(value = "loginName") String loginName){
		if(userService.findUserByLoginName(loginName) == null) 
			return "true";
		return "false";
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
		String username = req.getParameter("username");
		String password  = req.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return "redirect:/activiti/main";
			
		} catch (AuthenticationException e) {
			return login();
		}
		
	}
}
