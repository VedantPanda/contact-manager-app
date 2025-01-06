package com.contactmanager.app.entities;


import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String contactId;

    private String name;

    private String email;

//    private MultipartFile profileImage;

    private String phone;

    private String work;

    private String description;

    @ManyToOne
    private ContactUser contactUser;

}
