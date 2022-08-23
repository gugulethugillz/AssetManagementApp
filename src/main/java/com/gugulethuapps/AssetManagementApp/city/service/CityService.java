package com.gugulethuapps.AssetManagementApp.city.service;

import com.gugulethuapps.AssetManagementApp.city.model.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<City> findAll();
    Optional<City> findById(int id);
    void delete(int id);
    void save(City city);
}
