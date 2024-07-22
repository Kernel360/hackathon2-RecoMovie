package com.hackathonteam2.recomovie.user.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRequest {
    private Long userId;
    private String loginId;
    private String password;
    private String name;
    private String nickname;
    private String email;

}
