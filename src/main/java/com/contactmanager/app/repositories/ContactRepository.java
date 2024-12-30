package com.contactmanager.app.repositories;

import com.contactmanager.app.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, String> {



}
