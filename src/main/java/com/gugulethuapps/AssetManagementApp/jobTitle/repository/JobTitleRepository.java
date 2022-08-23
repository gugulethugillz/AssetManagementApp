package com.gugulethuapps.AssetManagementApp.jobTitle.repository;

import com.gugulethuapps.AssetManagementApp.jobTitle.model.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {

}
