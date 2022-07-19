package com.project.mirinae.domain.manual.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "manual")
public class Manual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private String title;

    private String content;

    private String category;

    @Builder
    public Manual(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }
}
