package com.hackathonteam2.recomovie;

import com.hackathonteam2.recomovie.movie.entity.Movie;
import com.hackathonteam2.recomovie.movie.service.MovieService;
import com.hackathonteam2.recomovie.review.entity.Review;
import com.hackathonteam2.recomovie.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MovieService movieService;
    private final ReviewService reviewService;

    @GetMapping("/home")
    public String getMovies(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "home";
    }
    @GetMapping("/movie/{id}")
    public String showMovieDetail(@PathVariable("id") Long movieId, Model model) {
        Movie movie = movieService.findByMovieId(movieId);
        List<Review> reviews = reviewService.getReviewsByMovieId(movieId);
        model.addAttribute("movie", movie);
        model.addAttribute("reviews", reviews);
        return "movie-detail";
    }
}
