package com.hackathonteam2.recomovie.review.service;

import com.hackathonteam2.recomovie.cinema.Cinema;
import com.hackathonteam2.recomovie.cinema.CinemaRepository;
import com.hackathonteam2.recomovie.movie.entity.Movie;
import com.hackathonteam2.recomovie.movie.repository.MovieRepository;
import com.hackathonteam2.recomovie.review.dto.ReviewRequest;
import com.hackathonteam2.recomovie.review.entity.Review;
import com.hackathonteam2.recomovie.review.repository.ReviewRepository;
import com.hackathonteam2.recomovie.user.entity.User;
import com.hackathonteam2.recomovie.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;


    public List<Review> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        reviews.sort((i,j)->Long.compare(j.getId(),i.getId()));
        return reviews;
    }

    @Transactional
    public void writeReview(String loginId, ReviewRequest request) {
        if (loginId == null) {
            throw new IllegalArgumentException("Login ID는 null일 수 없습니다.");
        }

        if (request.getMovieId() == null) {
            throw new IllegalArgumentException("Movie ID는 null일 수 없습니다.");
        }

        User user = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new RuntimeException("User not found"));

//        Cinema cinema = cinemaRepository.findById(request.getCinemaId())
//                .orElseThrow(() -> new RuntimeException("Cinema not found"));

        Movie movie = movieRepository.findByMovieId(request.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        Cinema cinema = cinemaRepository.findByBrandAndRegionAndName(request.getBrand(),request.getRegion(),request.getCinema()).get();
        Review review = new Review();
        review.setCinemaReview(request.getCinemaReview());
        review.setMovieReview(request.getMovieReview());
        review.setRating(request.getRating());
        review.setUser(user);
        review.setMovie(movie);
        review.setCinema(cinema);
        reviewRepository.save(review);
    }
}
