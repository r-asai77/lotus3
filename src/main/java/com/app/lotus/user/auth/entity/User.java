package com.app.lotus.user.auth.entity;

import com.app.lotus.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
public class User extends BaseEntity {

    @Setter
    @Column(length = 50, unique = true, nullable = false)
    private String loginId;

    @Column(length = 255, nullable = false)
    private String password;

    @Setter
    @Column(length = 50, nullable = false)
    private String firstName;

    @Setter
    @Column(length = 50, nullable = false)
    private String lastName;

    @Setter
    @Column(length = 255, nullable = false)
    private String email;

    @Setter
    @Column(length = 11, nullable = false)
    private String phoneNumber;

    public void setPassword(String encodedPassword) {
        this.password = encodedPassword;
    }
}
