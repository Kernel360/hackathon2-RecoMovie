package com.hackathonteam2.recomovie.review.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hackathonteam2.recomovie.cinema.entity.Cinema;
import com.hackathonteam2.recomovie.cinema.repository.CinemaRepository;
import com.hackathonteam2.recomovie.movie.entity.Movie;
import com.hackathonteam2.recomovie.movie.repository.MovieRepository;
import com.hackathonteam2.recomovie.review.dto.ReviewRequest;
import com.hackathonteam2.recomovie.review.entity.Review;
import com.hackathonteam2.recomovie.review.repository.ReviewRepository;
import com.hackathonteam2.recomovie.user.entity.User;
import com.hackathonteam2.recomovie.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {
	private final ReviewRepository reviewRepository;
	private final UserRepository userRepository;
	private final CinemaRepository cinemaRepository;
	private final MovieRepository movieRepository;

	public List<Review> getMyReviews(User user) {
		List<Review> reviews = reviewRepository.findByUser(user);
		log.info("Found {} reviews for user {}", reviews.size(), user.getLoginId());
		return reviews;
	}

	public List<Review> getMyReviewsByUserId(Long userId) {
		List<Review> reviews = reviewRepository.findAllByUserId(userId);
		log.info("Found {} reviews for userId {}", reviews.size(), userId);
		return reviews;
	}

	public List<Review> getReviewsByMovieId(Long movieId) {
		return reviewRepository.findByMovieMovieId(movieId);
	}

	public void saveReview(Review review) {
		reviewRepository.save(review);
	}

	public void writeReview(User user, ReviewRequest request, Cinema cinema, Movie movie) {
		Review review = new Review();
		review.setUser(user);
		review.setCinema(cinema);
		review.setMovie(movie);
		review.setMovieReview(request.getMovieReview());
		review.setCinemaReview(request.getCinemaReview());
		review.setRating(request.getRating());
		reviewRepository.save(review);
	}
}
