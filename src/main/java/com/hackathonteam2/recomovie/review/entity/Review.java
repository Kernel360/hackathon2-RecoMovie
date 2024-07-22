package com.hackathonteam2.recomovie.review.entity;

import com.hackathonteam2.recomovie.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reviews")
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private int rating;

    @ManyToOne
    @JoinColumn(name ="user_id",nullable = false)
    private User user;

}
