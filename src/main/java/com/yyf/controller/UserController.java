package com.yyf.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.yyf.model.User;
import com.yyf.service.UserService;

@Controller
@RequestMapping("/admin")
public class UserController {
	@Resource
	private UserService userService;

	@RequestMapping("/get-users")
	public @ResponseBody List<User> getUsers(Integer pageNo) throws Exception {
		if (pageNo == null) {
			pageNo = 1;
		}
		List<User> users = userService.getUsers();
		return users;
	}

	@RequestMapping("/user-list")
	public ModelAndView getUsersUI() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		List<User> users = userService.getUsers();
		modelAndView.addObject("users", users);
		modelAndView.setViewName("user/user-list.jsp");
		return modelAndView;
	}

	@RequestMapping("/user-add-ui")
	public String getUserAddUI() throws Exception {
		return "user/user-add.jsp";
	}

	@RequestMapping("/user-add-submit")
	public String userAddSubmit(Model model, @Valid User user, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			model.addAttribute("allErrors",allErrors);
			return "user/user-add.jsp";
		}
		userService.add(user);
		return "redirect:user-list";
	}

}