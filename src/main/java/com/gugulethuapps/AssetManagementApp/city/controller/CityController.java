package com.gugulethuapps.AssetManagementApp.city.controller;

import java.util.List;
import java.util.Optional;

import com.gugulethuapps.AssetManagementApp.city.model.City;
import com.gugulethuapps.AssetManagementApp.city.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class CityController {
	private final CityService cityService;

	@GetMapping("cities")
	public String findAll(Model model){
		model.addAttribute("cities", cityService.findAll());
		return "city";
	}

	@RequestMapping("cities/findById")
	@ResponseBody
	public Optional<City> findById(Integer id) {
		return cityService.findById(id);
	}

	@PostMapping("cities/addNew")
	public String addNew(City city) {
		cityService.save(city);
		return "redirect:/cities";
	}	
	
	@RequestMapping(value="cities/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(City city) {
		cityService.save(city);
		return "redirect:/cities";
	}
	
	@RequestMapping(value="cities/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		cityService.delete(id);
		return "redirect:/cities";
	}
}
