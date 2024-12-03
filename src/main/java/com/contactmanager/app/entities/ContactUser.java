package com.contactmanager.app.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class ContactUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "Name field is mandatory")
    @Size(min = 2, max = 30, message = "Minimum of 2 characters and maximum of 30 characters are allowed.")
    private String name;

    @Column(unique = true)
    @Email(message = "Invalid Email Address")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Min 6 characters are required")
    private String password;

    private String imageUrl;

    @NotBlank(message = "About yourself is mandatory")
    private String about;

    private String role;

    private boolean deleted;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contactUser")
    private List<Contact> contacts = new ArrayList<>();


}
