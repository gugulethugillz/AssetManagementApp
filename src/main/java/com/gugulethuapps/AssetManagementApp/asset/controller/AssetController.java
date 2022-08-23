package com.gugulethuapps.AssetManagementApp.asset.controller;

import java.util.Optional;

import com.gugulethuapps.AssetManagementApp.employee.service.EmployeeService;
import com.gugulethuapps.AssetManagementApp.asset.model.Asset;
import com.gugulethuapps.AssetManagementApp.asset.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AssetController {
	
	private final AssetService assetService;
	private final EmployeeService employeeService ;

	@GetMapping("assets")
	public String findAll(Model model){		
		model.addAttribute("vehicles", assetService.findAll());
		model.addAttribute("employees", employeeService.findAll());
		return "asset";
	}	
	
	@RequestMapping("assets/findById")
	@ResponseBody
	public Optional<Asset> findById(Integer id)
	{
		return assetService.findById(id);
	}

	@PostMapping(value="assets/addNew")
	public String addNew(Asset asset) {
		assetService.save(asset);
		return "redirect:/assets";
	}	
	
	@RequestMapping(value="assets/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Asset asset) {
		assetService.save(asset);
		return "redirect:/assets";
	}
	
	@RequestMapping(value="assets/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		assetService.delete(id);
		return "redirect:/assets";
	}
}
