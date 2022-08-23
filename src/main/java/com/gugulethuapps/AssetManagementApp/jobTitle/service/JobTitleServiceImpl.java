package com.gugulethuapps.AssetManagementApp.jobTitle.service;

import java.util.List;
import java.util.Optional;

import com.gugulethuapps.AssetManagementApp.jobTitle.model.JobTitle;
import com.gugulethuapps.AssetManagementApp.jobTitle.repository.JobTitleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class JobTitleServiceImpl implements JobTitleService {

	private final JobTitleRepository jobTitleRepository;

	public List<JobTitle> findAll(){
		return jobTitleRepository.findAll();
	}	

	public Optional<JobTitle> findById(int id) {
		return jobTitleRepository.findById(id);
	}	

	public void delete(int id) {
		jobTitleRepository.deleteById(id);
	}

	public void save(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}
}
