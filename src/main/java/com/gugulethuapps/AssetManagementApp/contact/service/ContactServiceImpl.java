package com.gugulethuapps.AssetManagementApp.contact.service;

import java.util.List;
import java.util.Optional;

import com.gugulethuapps.AssetManagementApp.contact.model.Contact;
import com.gugulethuapps.AssetManagementApp.contact.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
	
	private final ContactRepository contactRepository;

	public List<Contact> findAll(){
		return contactRepository.findAll();
	}	

	public Optional<Contact> findById(int id) {
		return contactRepository.findById(id);
	}	

	public void delete(int id) {
		contactRepository.deleteById(id);
	}

	public void save( Contact contact) {
		contactRepository.save(contact);
	}

}
