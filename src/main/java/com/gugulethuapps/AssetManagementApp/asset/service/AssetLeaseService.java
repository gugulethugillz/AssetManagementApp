package com.gugulethuapps.AssetManagementApp.asset.service;

import com.gugulethuapps.AssetManagementApp.asset.model.AssetLease;

import java.util.List;
import java.util.Optional;

public interface AssetLeaseService {
    public List<AssetLease> findAll();

    public Optional<AssetLease> findById(int id);
    public void delete(int id);
    public void save(AssetLease assetLease);
}
