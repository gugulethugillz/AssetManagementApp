package com.gugulethuapps.AssetManagementApp.city.repository;

import com.gugulethuapps.AssetManagementApp.city.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
