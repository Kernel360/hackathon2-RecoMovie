package com.hackathonteam2.recomovie.review.repository;

import com.hackathonteam2.recomovie.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
