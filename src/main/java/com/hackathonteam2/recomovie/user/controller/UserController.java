package com.hackathonteam2.recomovie.user.controller;

import com.hackathonteam2.recomovie.user.dto.LoginRequest;
import com.hackathonteam2.recomovie.user.entity.User;
import com.hackathonteam2.recomovie.user.repository.UserRepository;
import com.hackathonteam2.recomovie.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody LoginRequest request){

        String loginId = request.getLoginId();
        String password = request.getPassword();
        String name = request.getName();
        String nickname = request.getNickname();
        String email = request.getEmail();

        if(!userService.isUserExists(loginId)){
            User user = new User(loginId,password,name,nickname,email);
            userRepository.save(user);
            return "redirect:/login";
        } else{
            return "redirect:/register?error";
        }

    }


}
