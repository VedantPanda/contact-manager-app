package com.contactmanager.app.repositories;

import com.contactmanager.app.entities.ContactUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ContactUserRepository extends JpaRepository<ContactUser, String> {

    @Query("from contactUser cu where cu.email = :email")
    public Optional<ContactUser> findByEmailId(@Param("email") String email);

}
