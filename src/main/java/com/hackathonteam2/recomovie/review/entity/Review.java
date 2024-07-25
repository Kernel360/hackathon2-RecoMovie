package com.hackathonteam2.recomovie.review.entity;

import java.time.LocalDateTime;

import com.hackathonteam2.recomovie.cinema.entity.Cinema;
import com.hackathonteam2.recomovie.movie.entity.Movie;
import com.hackathonteam2.recomovie.user.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Review {

	@Id
	@Column(name = "review_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewId;

	@Lob
	@Column(name = "cinema_review", columnDefinition = "TEXT", nullable = false)
	private String cinemaReview;

	@ManyToOne
	@JoinColumn(name = "cinema_id", nullable = false)
	private Cinema cinema;

	@Lob
	@Column(name = "movie_review", columnDefinition = "TEXT", nullable = false)
	private String movieReview;

	@Column(nullable = false)
	private Integer rating;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "movie_id", nullable = false)
	private Movie movie;

	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;
}
