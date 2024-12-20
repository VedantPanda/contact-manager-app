package com.contactmanager.app.config;

import com.contactmanager.app.entities.ContactUser;
import com.contactmanager.app.repositories.ContactUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ContactUserRepository contactUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<ContactUser> contactUserOptional = contactUserRepository.findByEmail(username);

        if(contactUserOptional.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomUserDetails(contactUserOptional.get());

    }
}
