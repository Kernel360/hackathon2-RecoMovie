package com.hackathonteam2.recomovie.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hackathonteam2.recomovie.cinema.service.CinemaService;
import com.hackathonteam2.recomovie.review.dto.ReviewRequest;
import com.hackathonteam2.recomovie.review.service.ReviewService;
import com.hackathonteam2.recomovie.user.entity.User;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewController {

	private final ReviewService reviewService;

	private final CinemaService cinemaService;

	@GetMapping("/reviews")
	public String showReviewForm() {
		return "review_form";
	}

	@PostMapping("reviews/write")
	public String writeReview(
		@ModelAttribute ReviewRequest request
		, HttpSession httpSession) {
		User user = (User)httpSession.getAttribute("loggedInUser");
		if (user != null) {
			String loginId = user.getLoginId();
			System.out.println("request = " + request);
			System.out.println(cinemaService.findId(request.getBrand(), request.getRegion(), request.getCinema()));
			reviewService.writeReview(loginId, request);
			return "redirect:/home";
		} else {
			return "redirect:/login?error";
		}
	}
}