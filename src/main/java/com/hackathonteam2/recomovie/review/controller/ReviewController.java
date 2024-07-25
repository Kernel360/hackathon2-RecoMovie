package com.hackathonteam2.recomovie.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hackathonteam2.recomovie.cinema.entity.Cinema;
import com.hackathonteam2.recomovie.cinema.service.CinemaService;
import com.hackathonteam2.recomovie.movie.dto.TMDBDetailsDto;
import com.hackathonteam2.recomovie.movie.service.MovieService;
import com.hackathonteam2.recomovie.movie.service.TMDBService;
import com.hackathonteam2.recomovie.review.dto.ReviewRequest;
import com.hackathonteam2.recomovie.review.service.ReviewService;
import com.hackathonteam2.recomovie.user.entity.User;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ReviewController {

	private final ReviewService reviewService;
	private final MovieService movieService;
	private final CinemaService cinemaService;
	private final TMDBService tmdbService;

	@GetMapping("/review")
	public String showReviewForm(@RequestParam Long movieId, Model model) throws JsonProcessingException {
		model.addAttribute("movieId", movieId);
		model.addAttribute("movie", tmdbService.getDetails(movieId));
		return "review-form";
	}

	@PostMapping("/reviews/write")
	public String writeReview(
		@ModelAttribute ReviewRequest reviewRequest,
		HttpSession httpSession) {

		User user = (User)httpSession.getAttribute("loggedInUser");

		if (user != null) {
			Cinema cinema = cinemaService.findByName(reviewRequest.getCinema());

			TMDBDetailsDto tmdbDetailsDto = movieService.save(reviewRequest);

			reviewService.writeReview(user, reviewRequest, cinema, tmdbDetailsDto);

			return "redirect:/movie/" + tmdbDetailsDto.getMovie_id();
		} else {
			return "redirect:/login?error";
		}
	}
}