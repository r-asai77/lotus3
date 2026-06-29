package com.app.lotus.admin.auth.entity;

import com.app.lotus.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admins")
@Getter
@NoArgsConstructor
public class Admin extends BaseEntity {

    @Setter
    @Column(length = 50, unique = true, nullable = false)
    private String loginId;

    @Column(length = 255, nullable = false)
    private String password;

    @Setter
    @Column(length = 100, nullable = false)
    private String name;

    @Setter
    @Column(length = 255, nullable = false)
    private String email;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private AdminRole role;

    public void setPassword(String encodedPassword) {
        this.password = encodedPassword;
    }
}
