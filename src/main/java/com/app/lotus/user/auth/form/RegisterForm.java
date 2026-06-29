package com.app.lotus.user.auth.form;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegisterForm {

    @NotBlank
    @Size(max = 50)
    private String loginId;

    @NotBlank
    @Size(min = 6, max = 100)
    private String password;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotBlank
    @Email
    @Size(max = 255)
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{10,11}", message = "電話番号は10〜11桁の数字で入力してください")
    private String phoneNumber;
}
