package com.hackathonteam2.recomovie.mypage.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hackathonteam2.recomovie.review.entity.Review;
import com.hackathonteam2.recomovie.review.service.ReviewService;
import com.hackathonteam2.recomovie.user.entity.User;
import com.hackathonteam2.recomovie.user.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MyPageController {

	private final UserService userService;
	private final ReviewService reviewService;

	@GetMapping("/mypage")
	public String myPage(HttpSession httpSession, Model model) {
		User user = (User)httpSession.getAttribute("loggedInUser");

		if (user == null) {
			log.error("User not found in session.");
			return "errorPage";
		}
		log.info("User found: {}", user.getLoginId());

		List<Review> myReviews = reviewService.getMyReviews(
			user); // or reviewService.getMyReviewsByUserId(user.getUserId());

		if (myReviews.isEmpty()) {
			log.info("No reviews found for user: {}", user.getLoginId());
		} else {
			log.info("Reviews found: {}", myReviews);
		}

		model.addAttribute("user", user);
		model.addAttribute("myReviews", myReviews);

		return "mypage";
	}
}
