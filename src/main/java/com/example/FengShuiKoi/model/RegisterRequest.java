package com.example.FengShuiKoi.model;


import com.example.FengShuiKoi.entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //getter va setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "Code can not be blank!")
    @Pattern(regexp = "KH\\d{6}",message = "Invalid Code!")
    @Column(unique = true)
    String code;

    @Email(message = "Invalid Email!")
    @Column(unique = true)
    String email;

    @Pattern(regexp = "(84|0[3|5|7|8|9])+(\\d{8})", message = "Invalid Phone!")
    @Column(unique = true)
    String phone;

    @Size(min=6, message = "Password must be at least 6 character!")
    String password;

    @Enumerated(EnumType.STRING)
    Role role;
}
