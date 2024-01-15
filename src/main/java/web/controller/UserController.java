package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String usersList(ModelMap model) {
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("user", new User());
		return "users_list";
	}

	@PostMapping(value = "/create")
	public String createUser(@ModelAttribute User user, ModelMap model) {
		userService.createUser(user);
		return "redirect:/";
	}

	@GetMapping(value = "/delete")
	public String deleteUser(@RequestParam(value = "id") long id, ModelMap model) {
		userService.deleteUser(id);
		return "redirect:/";
	}

	@GetMapping(value = "/edit")
	public String editUserForm(@RequestParam(value = "id") long id, ModelMap model) {
		model.addAttribute("user", userService.getUserByID(id));
		return "user_form";
	}

	@PostMapping(value = "/edit")
	public String editUser(@ModelAttribute User user, ModelMap model) {
		userService.editUser(user);
		return "redirect:/";
	}

}