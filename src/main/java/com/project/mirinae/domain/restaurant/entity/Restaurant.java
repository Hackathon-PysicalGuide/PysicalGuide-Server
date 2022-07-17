package com.project.mirinae.domain.restaurant.entity;

import com.project.mirinae.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "restaurant")
public class Restaurant {

    @Id
    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "userId")
    private User user;

    private String content;

    private double longitude;

    private double latitude;

    @Builder
    public Restaurant(String title, User user, String content, double longtitude, double latitude) {
        this.title = title;
        this.user = user;
        this.content = content;
        this.longitude = longtitude;
        this.latitude = latitude;
    }
}