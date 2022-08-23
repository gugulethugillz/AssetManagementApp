package com.gugulethuapps.AssetManagementApp.asset.service.impl;

import java.util.List;
import java.util.Optional;

import com.gugulethuapps.AssetManagementApp.asset.model.AssetLease;
import com.gugulethuapps.AssetManagementApp.asset.repository.AssetLeaseRepository;
import com.gugulethuapps.AssetManagementApp.asset.service.AssetLeaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AssetLeaseServiceImpl implements AssetLeaseService {
	@Autowired
	private AssetLeaseRepository assetLeaseRepository;

	public List<AssetLease> findAll(){
		return assetLeaseRepository.findAll();
	}	

	public Optional<AssetLease> findById(int id) {
		return assetLeaseRepository.findById(id);
	}	

	public void delete(int id) {
		assetLeaseRepository.deleteById(id);
	}

	public void save(AssetLease assetLease) {
		assetLeaseRepository.save(assetLease);
	}

}
