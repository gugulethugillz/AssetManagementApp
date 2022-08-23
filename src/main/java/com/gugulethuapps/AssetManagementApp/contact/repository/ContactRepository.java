package com.gugulethuapps.AssetManagementApp.contact.repository;

import com.gugulethuapps.AssetManagementApp.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
