package com.gugulethuapps.AssetManagementApp.asset.service;

import com.gugulethuapps.AssetManagementApp.asset.model.Asset;

import java.util.List;
import java.util.Optional;

public interface AssetService {
     List<Asset> findAll();

    Optional<Asset> findById(int id);

   void delete(int id);

    void save(Asset asset);
}
