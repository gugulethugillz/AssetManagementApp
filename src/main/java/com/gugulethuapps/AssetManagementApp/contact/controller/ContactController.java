package com.gugulethuapps.AssetManagementApp.contact.controller;

import java.util.Optional;

import com.gugulethuapps.AssetManagementApp.contact.model.Contact;
import com.gugulethuapps.AssetManagementApp.contact.service.ContactService;
import com.gugulethuapps.AssetManagementApp.city.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ContactController {
	
	private final CityService cityService;
	private final ContactService contactService;

	@GetMapping("/contacts")
	public String findAll(Model model){
		model.addAttribute("states", cityService.findAll());
		model.addAttribute("contacts", contactService.findAll());
		return "contact";
	}	
	
	@RequestMapping("contacts/findById") 
	@ResponseBody
	public Optional<Contact> findById(Integer id)
	{
		return contactService.findById(id);
	}

	@PostMapping(value="contacts/addNew")
	public String addNew(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}	
	
	@RequestMapping(value="contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}
	
	@RequestMapping(value="contacts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		contactService.delete(id);
		return "redirect:/contacts";
	}

}
