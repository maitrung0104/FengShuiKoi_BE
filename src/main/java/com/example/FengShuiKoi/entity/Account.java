package com.example.FengShuiKoi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Enumerated(EnumType.STRING)
    Role role;
    @NotBlank(message = "Code can not be blank!")
    @Pattern(regexp = "KH\\d{6}",message = "Invalid Code!")
    @Column(unique = true)
    String code;
    @Email(message = "Email not valid!")
    String email;
    @Pattern(regexp="(84|0[3|5|7|8|9])+(\\d{8})",message = "Phone invalid")
    String phone;
    Date createAt;
    @NotBlank(message = "Password can not be blank")
    @Size(min = 6, message = "Password must be at least 6 characters!")
    String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities= new ArrayList<>();
        if(this.role!=null){
            authorities.add(new SimpleGrantedAuthority(this.role.toString()));

        }
        return authorities;
    }
    @Override
    public String getUsername() {
        return this.email;
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
}
