package com.app.lotus.admin.auth.repository;

import com.app.lotus.admin.auth.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByLoginId(String loginId);
    boolean existsByLoginId(String loginId);
}
