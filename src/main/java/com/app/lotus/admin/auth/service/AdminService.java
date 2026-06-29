package com.app.lotus.admin.auth.service;

import com.app.lotus.admin.auth.entity.Admin;
import com.app.lotus.admin.auth.entity.AdminRole;
import com.app.lotus.admin.auth.exception.DuplicateAdminLoginIdException;
import com.app.lotus.admin.auth.form.AdminRegisterForm;
import com.app.lotus.admin.auth.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(AdminRegisterForm form) {
        if (adminRepository.existsByLoginId(form.getLoginId())) {
            throw new DuplicateAdminLoginIdException();
        }
        Admin admin = new Admin();
        admin.setLoginId(form.getLoginId());
        admin.setPassword(passwordEncoder.encode(form.getPassword()));
        admin.setName(form.getName());
        admin.setEmail(form.getEmail());
        admin.setRole(AdminRole.GENERAL);
        try {
            adminRepository.save(admin);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateAdminLoginIdException();
        }
    }
}
