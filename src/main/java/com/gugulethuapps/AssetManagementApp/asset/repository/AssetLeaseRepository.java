package com.gugulethuapps.AssetManagementApp.asset.repository;

import com.gugulethuapps.AssetManagementApp.asset.model.AssetLease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetLeaseRepository extends JpaRepository<AssetLease, Integer> {

}
