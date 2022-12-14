package com.gugulethuapps.AssetManagementApp.User.controller;

import java.util.Optional;

import com.gugulethuapps.AssetManagementApp.User.model.User;
import com.gugulethuapps.AssetManagementApp.User.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;

	@GetMapping("users")
	public String findAll(Model model){		
		return "user";
	}	
	
	@RequestMapping("users/findById") 
	@ResponseBody
	public Optional<User> findById(Integer id)
	{
		return userService.findById(id);
	}

	@PostMapping(value="users/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {
		userService.save(user);
		RedirectView redirectView = new RedirectView("/login", true);
		redir.addFlashAttribute("message", "You have successfully registered. You can now login");
		return redirectView;
	}	
	
	@RequestMapping(value="users/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(User user) {
		userService.save(user);
		return "redirect:/users";
	}
	
	@RequestMapping(value="users/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		userService.delete(id);
		return "redirect:/users";
	}


}
