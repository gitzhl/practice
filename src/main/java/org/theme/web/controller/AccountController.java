package org.theme.web.controller;

import java.io.UnsupportedEncodingException;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.theme.entity.User;
import org.theme.web.command.LoginCommand;
import org.theme.web.command.SignupCommand;
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
	public String reg(Model model,@ModelAttribute SignupCommand command,BindingResult errors) throws UnsupportedEncodingException{
		if(errors.hasErrors()){
			return reg(model,command);
		}
		userService.save(command);
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
	public String reg(Model model,@ModelAttribute SignupCommand command){
		return "account/reg";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(Model model,@ModelAttribute LoginCommand command){
		return "account/login";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(Model model,@ModelAttribute LoginCommand command,BindingResult errors){
		UsernamePasswordToken token = new UsernamePasswordToken(command.getUsername(),new Md5Hash(command.getPassword()).toHex());
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return "redirect:/activiti/main";
		} catch (AuthenticationException e) {
			token.clear();
			return login(model,command);
		}
	}
}
