package com.gugulethuapps.AssetManagementApp.contact.service;

import com.gugulethuapps.AssetManagementApp.contact.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> findAll();
    Optional<Contact> findById(int id);
    void delete(int id);
    void save( Contact contact);
}
