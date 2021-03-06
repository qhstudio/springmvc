package com.yyf.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yyf.base.Response;
import com.yyf.model.User;
import com.yyf.service.UserService;

@Controller
@RequestMapping("/admin")
public class UserController {
	@Resource
	private UserService userService;

	/**
	 * 得到所有用户(json数据)
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/get-users")
	public @ResponseBody List<User> getUsers() throws Exception {
		List<User> users = userService.getUsers();
		return users;
	}

	/**
	 * 得到某一用户(restful风格)
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/get-user/{id}")
	public @ResponseBody Response getUser(@PathVariable("id") Long id) throws Exception {
		Response resp = new Response();
		User user = userService.getUser(id);
		if (user == null) {
			resp.failure("用户不存在");
		} else {
			resp.success(user);
		}
		return resp;
	}

	/**
	 * 显示用户列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/user-list")
	public ModelAndView getUsersUI() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		List<User> users = userService.getUsers();
		modelAndView.addObject("users", users);
		modelAndView.setViewName("user/user-list.jsp");
		return modelAndView;
	}

	/**
	 * 跳转到用户增加页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/user-add-ui")
	public String getUserAddUI() throws Exception {
		return "user/user-add.jsp";
	}

	/**
	 * 用户增加数据提交
	 * @param model
	 * @param user
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/user-add-submit")
	public String userAddSubmit(Model model, @Valid User user, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			return "user/user-add.jsp";
		}
		userService.add(user);
		return "redirect:user-list";
	}

}
