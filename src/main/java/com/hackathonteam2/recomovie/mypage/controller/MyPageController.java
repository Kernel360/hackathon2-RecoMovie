package com.hackathonteam2.recomovie.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hackathonteam2.recomovie.user.entity.User;
import com.hackathonteam2.recomovie.user.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyPageController {

	private final UserService userService;

	@GetMapping("/mypage")
	public String myPage(HttpSession httpSession, Model model) {
		User user = (User) httpSession.getAttribute("loggedInUser");
		if (user == null) {
			return "errorPage";
		}
		model.addAttribute("user", user);
		return "myPage";
	}

}