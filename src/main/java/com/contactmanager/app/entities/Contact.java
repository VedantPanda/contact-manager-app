package com.contactmanager.app.entities;

import jakarta.persistence.*;
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

    private String password;

    private String imageUrl;

    private String description;

    private String work;

    private boolean deleted;

    @ManyToOne
    private User user;

}
