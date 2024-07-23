package com.hackathonteam2.recomovie.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackathonteam2.recomovie.review.entity.Review;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NonNull
    @Column
    private String loginId;

    @NonNull
    @Column
    private String password;

    @NonNull
    @Column
    private String name;

    @NonNull
    @Column
    private String email;

    @NonNull
    @Column
    private String nickname;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Review> reviews;

//    @NonNull
//    @Column
//    private String createdDate;

    @Column
    private String role;


    public User( @NonNull String loginId, @NonNull String password, @NonNull String name, @NonNull String email,@NonNull String nickname) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.nickname = nickname;

    }


    public User() {

    }
}


