package com.app.lotus.user.auth.service;

import com.app.lotus.user.auth.entity.User;
import com.app.lotus.user.auth.exception.DuplicateLoginIdException;
import com.app.lotus.user.auth.form.RegisterForm;
import com.app.lotus.user.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(RegisterForm form) {
        if (userRepository.existsByLoginId(form.getLoginId())) {
            throw new DuplicateLoginIdException();
        }

        User user = new User();
        user.setLoginId(form.getLoginId());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setLastName(form.getLastName());
        user.setFirstName(form.getFirstName());
        user.setEmail(form.getEmail());
        user.setPhoneNumber(form.getPhoneNumber());

        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateLoginIdException();
        }
    }
}
