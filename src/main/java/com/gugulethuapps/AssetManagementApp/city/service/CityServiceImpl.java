package com.gugulethuapps.AssetManagementApp.city.service;

import java.util.List;
import java.util.Optional;

import com.gugulethuapps.AssetManagementApp.city.model.City;
import com.gugulethuapps.AssetManagementApp.city.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
	private final CityRepository cityRepository;

	public List<City> findAll(){
		return cityRepository.findAll();
	}	

	public Optional<City> findById(int id) {
		return cityRepository.findById(id);
	}	

	public void delete(int id) {
		cityRepository.deleteById(id);
	}

	public void save( City city) {
		cityRepository.save(city);
	}
}
