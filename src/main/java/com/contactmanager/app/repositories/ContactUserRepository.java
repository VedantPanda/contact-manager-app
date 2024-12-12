package com.contactmanager.app.repositories;

import com.contactmanager.app.entities.ContactUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ContactUserRepository extends JpaRepository<ContactUser, String> {

    @Query("from ContactUser cu where cu.email = :email")
    Optional<ContactUser> findByEmail(@Param("email") String email);

}
