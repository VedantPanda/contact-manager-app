package com.contactmanager.app.repositories;

import com.contactmanager.app.entities.ContactUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactUserRepository extends JpaRepository<ContactUser, String> {

}
