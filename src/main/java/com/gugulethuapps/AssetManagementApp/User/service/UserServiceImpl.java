package com.gugulethuapps.AssetManagementApp.User.service;

import java.util.List;
import java.util.Optional;

import com.gugulethuapps.AssetManagementApp.User.model.User;
import com.gugulethuapps.AssetManagementApp.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	public List<User> findAll(){
		return userRepository.findAll();
	}	

	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}	

	public void delete(int id) {
		userRepository.deleteById(id);
	}

	public void save(User user) {
		userRepository.save(user);
	}

}
