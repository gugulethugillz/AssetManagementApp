package com.gugulethuapps.AssetManagementApp.asset.controller;

import java.util.Optional;

import com.gugulethuapps.AssetManagementApp.asset.model.AssetLease;
import com.gugulethuapps.AssetManagementApp.asset.service.AssetLeaseService;
import com.gugulethuapps.AssetManagementApp.asset.service.AssetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AssetLeaseController {
	
	private final AssetLeaseService assetLeaseService;
	private final AssetService assetService;

	@GetMapping("assetLeases")
	public String findAll(Model model){		
		model.addAttribute("assetLeases", assetLeaseService.findAll());
		model.addAttribute("assets", assetService.findAll());

		return "assetLease";
	}	
	
	@RequestMapping("assetLeases/findById")
	@ResponseBody
	public Optional<AssetLease> findById(Integer id)
	{
		return assetLeaseService.findById(id);
	}

	@PostMapping(value="assetLeases/addNew")
	public String addNew(AssetLease assetLease) {
		assetLeaseService.save(assetLease);
		return "redirect:/assetLeases";
	}	
	
	@RequestMapping(value="assetLeases/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(AssetLease assetLease) {
		assetLeaseService.save(assetLease);
		return "redirect:/assetLeases";
	}
	
	@RequestMapping(value="assetLeases/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		assetLeaseService.delete(id);
		return "redirect:/assetLeases";
	}

}
