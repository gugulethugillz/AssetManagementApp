package com.gugulethuapps.AssetManagementApp.jobTitle.controller;

import java.util.Optional;

import com.gugulethuapps.AssetManagementApp.jobTitle.model.JobTitle;
import com.gugulethuapps.AssetManagementApp.jobTitle.service.JobTitleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class JobTitleController {
	
	private final JobTitleService jobTitleService;

	@GetMapping("jobTitles")
	public String findAll(Model model){		
		model.addAttribute("jobTitles", jobTitleService.findAll());
		return "jobTitle";
	}	
	
	@RequestMapping("jobTitles/findById") 
	@ResponseBody
	public Optional<JobTitle> findById(Integer id)
	{
		return jobTitleService.findById(id);
	}

	@PostMapping(value="jobTitles/addNew")
	public String addNew(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobTitles";
	}	
	
	@RequestMapping(value="jobTitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(JobTitle jobTitle) {
		jobTitleService.save(jobTitle);
		return "redirect:/jobTitles";
	}
	
	@RequestMapping(value="jobTitles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		jobTitleService.delete(id);
		return "redirect:/jobTitles";
	}

}
