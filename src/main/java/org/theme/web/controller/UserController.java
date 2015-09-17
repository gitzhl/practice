package org.theme.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.theme.entity.User;
import org.theme.web.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user",method = RequestMethod.GET)
	public String findUser(@RequestParam(name = "id") long id,Model model){
		User user = userService.getUser(id);
		System.out.println(user.getName());
		model.addAttribute("user",user);
		return "user/detail";
	}
}
