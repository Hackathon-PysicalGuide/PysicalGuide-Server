package com.project.mirinae.domain.user.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class User {

    @Id
    private String userId;

    private String pw;

    @Builder
    public User(String userId, String pw) {
        this.userId = userId;
        this.pw = pw;
    }

}
