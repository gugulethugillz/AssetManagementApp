package com.gugulethuapps.AssetManagementApp.jobTitle.service;

import com.gugulethuapps.AssetManagementApp.jobTitle.model.JobTitle;

import java.util.List;
import java.util.Optional;

public interface JobTitleService {
    List<JobTitle> findAll();
    Optional<JobTitle> findById(int id);
    void delete(int id);
    void save(JobTitle jobTitle);
}
