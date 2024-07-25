package com.hackathonteam2.recomovie.review.repository;

import java.util.List;
import java.util.Optional;
import com.hackathonteam2.recomovie.review.entity.Review;
import com.hackathonteam2.recomovie.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	@Query("select r from Review r where r.user.userId = :userId")
	List<Review> findAllByUserId(@Param("userId") Long userId);

	List<Review> findByUser(User user); // 기존 메서드도 유지


	List<Review> findByMovieMovieId(Long movieId);


	Optional<List<Review>> findAllByCinemaId(Long cinemaId);
	Optional<List<Review>> findAllByMovieId(Long movieId);

}
