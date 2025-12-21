package com.scm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    private String userId;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @Column(length = 1000)
    private String about;
    @Column(length = 1000)
    private String profilePic;
    private String phoneNumber;

    private boolean enabled = false;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;

    // How user logged into Application
    // SELF, GOOGLE, FACEBOOK, TWITER
    private Providers provider = Providers.SELF;// BY Default
    private String providerUserId;

    // Add more feilds if needed
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    /*
     * 1) cascade mhnje jar user delete jhala tr tyachya barobr mapped vale sagle
     * Contact delte honar
     * 2) One to Many mhnje eka user kade multiple contacts ahet.
     * 3) Fetch type lazy means jo paryant contacts chi garaj nahi to parynat
     * database madhe query run honar nahi jevha contactsget jru tevha database
     * madhe query chalel
     */
    private List<Contact> contacts = new ArrayList<>();

}