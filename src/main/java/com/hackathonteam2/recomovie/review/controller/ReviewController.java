package com.hackathonteam2.recomovie.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hackathonteam2.recomovie.cinema.entity.Cinema;
import com.hackathonteam2.recomovie.cinema.service.CinemaService;
import com.hackathonteam2.recomovie.movie.entity.Movie;
import com.hackathonteam2.recomovie.movie.service.MovieService;
import com.hackathonteam2.recomovie.review.dto.ReviewRequest;
import com.hackathonteam2.recomovie.review.service.ReviewService;
import com.hackathonteam2.recomovie.user.entity.User;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewController {

	private final ReviewService reviewService;
	private final MovieService movieService;
	private final CinemaService cinemaService;

	@GetMapping("/review")
	public String showReviewForm(@RequestParam Long movieId, Model model) {
		model.addAttribute("movieId", movieId);
		model.addAttribute("movie", movieService.findByMovieId(movieId));
		return "review-form";
	}

	@PostMapping("/reviews/write")
	public String writeReview(
		@ModelAttribute ReviewRequest reviewRequest,
		@RequestParam Long movieId,
		HttpSession httpSession) {

		User user = (User)httpSession.getAttribute("loggedInUser");

		if (user != null) {
			Cinema cinema = cinemaService.findByName(reviewRequest.getCinema());
			Movie movie = movieService.findByMovieId(movieId);
			reviewService.writeReview(user, reviewRequest, cinema, movie);
			return "redirect:/movie/" + movieId;
		} else {
			return "redirect:/login?error";
		}
	}
}