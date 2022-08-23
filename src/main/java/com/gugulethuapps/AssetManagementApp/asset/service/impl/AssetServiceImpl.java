package com.gugulethuapps.AssetManagementApp.asset.service.impl;

import java.util.List;
import java.util.Optional;

import com.gugulethuapps.AssetManagementApp.asset.model.Asset;
import com.gugulethuapps.AssetManagementApp.asset.repository.AssetRepository;
import com.gugulethuapps.AssetManagementApp.asset.service.AssetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {
	
	@Autowired
	private AssetRepository assetRepository;

	public List<Asset> findAll(){
		return assetRepository.findAll();
	}	

	public Optional<Asset> findById(int id) {
		return assetRepository.findById(id);
	}	

	public void delete(int id) {
		assetRepository.deleteById(id);
	}

	public void save(Asset asset) {
		assetRepository.save(asset);
	}

}
