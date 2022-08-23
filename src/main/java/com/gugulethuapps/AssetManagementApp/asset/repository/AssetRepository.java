package com.gugulethuapps.AssetManagementApp.asset.repository;

import com.gugulethuapps.AssetManagementApp.asset.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer>{

}
