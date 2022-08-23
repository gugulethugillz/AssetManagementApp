package com.gugulethuapps.AssetManagementApp.User.repository;

import com.gugulethuapps.AssetManagementApp.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
	
}
