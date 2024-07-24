package com.hackathonteam2.recomovie;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hackathonteam2.recomovie.movie.dto.NowPlayingResponse;
import com.hackathonteam2.recomovie.movie.dto.TMDBDetailsDto;
import com.hackathonteam2.recomovie.movie.service.MovieService;
import com.hackathonteam2.recomovie.movie.service.TMDBService;
import com.hackathonteam2.recomovie.review.entity.Review;
import com.hackathonteam2.recomovie.review.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

	private final MovieService movieService;
	private final ReviewService reviewService;
	private final TMDBService tmdbService;

	@GetMapping("/home")
	public String getMovies(Model model) throws JsonProcessingException {
		NowPlayingResponse response = tmdbService.getNowPlaying(1);
		model.addAttribute("response", response);
		return "home";
	}

	@GetMapping("/movie/{id}")
	public String showMovieDetail(@PathVariable("id") Long movieId, Model model) throws JsonProcessingException {
		TMDBDetailsDto tmdbDetailsDto = tmdbService.getDetails(movieId);
		List<Review> reviews = reviewService.getReviewsByMovieId(movieId);
		model.addAttribute("movie", tmdbDetailsDto);
		model.addAttribute("reviews", reviews);
		return "movie-detail";
	}
}
