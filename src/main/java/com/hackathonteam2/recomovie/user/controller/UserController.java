package com.hackathonteam2.recomovie.user.controller;

import java.io.IOException;

import com.hackathonteam2.recomovie.user.dto.LoginRequest;
import com.hackathonteam2.recomovie.user.entity.User;
import com.hackathonteam2.recomovie.user.repository.UserRepository;
import com.hackathonteam2.recomovie.user.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/")
    public String loginHome(){
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute LoginRequest request, @RequestParam("profileImage") MultipartFile profileImage) {

        String loginId = request.getLoginId();
        String password = request.getPassword();
        String name = request.getName();
        String nickname = request.getNickname();
        String email = request.getEmail();

        try {
            userService.createUser(loginId, password, name, email, nickname, profileImage);
            return "redirect:/login";
        } catch (IllegalArgumentException | IOException e) {
            return "redirect:/register?error";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String loginId, @RequestParam String password, HttpSession httpSession){
        boolean isLogin = userService.loginService(loginId,password);
        if(isLogin){
            User user = userService.getUserByLoginId(loginId);
            httpSession.setAttribute("loggedInUser", user);
            return "redirect:/home";
        } else {
            return "redirect:/login?error";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/login";
    }


}
