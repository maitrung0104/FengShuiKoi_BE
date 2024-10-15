package com.example.FengShuiKoi.model;

<<<<<<< HEAD
import com.example.FengShuiKoi.entity.Enum.Role;
=======
import com.example.FengShuiKoi.entity.Role;
>>>>>>> origin/forgot-password
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {


    @NotBlank(message = "Username is mandatory")
    @Column(unique = true)
    String username;

    @Email(message = "Invalid Email!")
    @Column(unique = true)
    String email;

    @Pattern(regexp = "(84|0[3|5|7|8|9])+(\\d{8})", message = "Invalid Phone!")
    @Column(unique = true)
    String phone;

    @Size(min=6, message = "Password must be at least 6 character!")
    String password;

    Role role;

}
