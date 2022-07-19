package com.project.mirinae.domain.user.repository;

import com.project.mirinae.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUserId(String userId);

    List<User> findAllByUserId(String userId);

    User getReferenceByUserId(String userId);

}
