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
        Optional<ContactUser> contactUser = contactUserRepository.findByEmailId(username);
        if(contactUser.isEmpty()){
            throw new UsernameNotFoundException("User Not Found");
        }
        return new ContactUserDetailsImpl(contactUser.get());
    }
}
