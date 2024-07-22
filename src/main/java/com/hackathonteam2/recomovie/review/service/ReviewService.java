package com.hackathonteam2.recomovie.review.service;

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

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    @Transactional
    public void writeReview(String longId, String content, int rating){
        User user = userRepository.findByLoginId(longId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Review review = new Review();
        review.setContent(content);
        review.setRating(rating);
        review.setUser(user);

        reviewRepository.save(review);
    }



}
