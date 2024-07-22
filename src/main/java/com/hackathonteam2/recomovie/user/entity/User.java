package com.hackathonteam2.recomovie.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

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


