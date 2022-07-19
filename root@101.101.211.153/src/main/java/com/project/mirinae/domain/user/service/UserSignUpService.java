package com.project.mirinae.domain.user.service;

import com.project.mirinae.domain.user.exception.UserAlreadyExistsByIdException;
import com.project.mirinae.domain.user.presentation.dto.response.UserResponse;
import com.project.mirinae.domain.user.entity.User;
import com.project.mirinae.domain.user.presentation.dto.request.UserSignUpRequest;
import com.project.mirinae.domain.user.presentation.dto.response.UserSignUpResponse;
import com.project.mirinae.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserSignUpService {

    private final Logger log = LoggerFactory.getLogger(UserSignUpService.class);
    private final UserRepository userRepository;

    @Transactional
    public UserSignUpResponse execute(UserSignUpRequest request) {
        userRepository.findByUserId(request.getId())
                .ifPresent(m -> {
                    throw UserAlreadyExistsByIdException.EXCEPTION;
                });

        User user = User.builder()
                .userId(request.getId())
                .pw(request.getPw())
                .build();
        user = userRepository.save(user);

        UserResponse userData = UserResponse.builder()
                .userId(user.getUserId())
                .build();

        log.info("signUp Success!!");

        return UserSignUpResponse.builder()
                .userData(userData)
                .build();
    }

}
