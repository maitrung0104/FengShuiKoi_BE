package com.example.FengShuiKoi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
public class Account implements UserDetails {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)

    @NotNull(message = "ID is mandatory")
    long id;

    @Enumerated(EnumType.STRING)
    Role role;


    @NotBlank(message = "Username is mandatory")
    @Column(unique = true)
    String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password must be at least 8 characters long")
    @Column(unique = true)
    String password;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @Column(unique = true)
    String email;

    @Pattern(regexp = "(84|0[3|5|7|8|9])+(\\d{8})\\b" , message = "Invalid phone number")
    @Column(unique = true)
    String phone;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities= new ArrayList<>();
        if(this.role!=null){
            authorities.add(new SimpleGrantedAuthority(this.role.toString()));

        }
        return authorities;
    }
    @Override
    public String getUsername(){
        return this.username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    List<User> users;
}

