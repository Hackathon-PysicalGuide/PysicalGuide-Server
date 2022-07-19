package com.project.mirinae.domain.user.service;

import com.project.mirinae.domain.user.entity.User;
import com.project.mirinae.domain.user.exception.PasswordWrongException;
import com.project.mirinae.domain.user.exception.UserNotFoundException;
import com.project.mirinae.domain.user.presentation.dto.request.UserSignInRequest;
import com.project.mirinae.domain.user.presentation.dto.response.UserSignInResponse;
import com.project.mirinae.domain.user.presentation.dto.response.UserResponse;
import com.project.mirinae.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignInService {

    private final Logger log = LoggerFactory.getLogger(UserSignInService.class);
    private final UserRepository userRepository;

    public UserSignInResponse execute(UserSignInRequest request) {

        User loginUser = userRepository.findByUserId(request.getId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        UserResponse userData = UserResponse.builder()
                .userId(loginUser.getUserId())
                .build();

        if(!loginUser.getPw().equals(request.getPw())) throw PasswordWrongException.EXCEPTION;

        log.info("signIn Success!!");

        return UserSignInResponse.builder()
                .userData(userData)
                .build();
    }

}
