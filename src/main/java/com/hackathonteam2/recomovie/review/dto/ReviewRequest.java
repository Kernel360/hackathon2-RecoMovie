package com.hackathonteam2.recomovie.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReviewRequest {

	private String brand;

	private String region;

	private String cinema;

	private String cinemaReview;

	private Long movieId;

	private String title;

	private String posterPath;

	private String releaseDate;

	private Integer runtime;

	private String overview;

	private String movieReview;

	private Integer rating;
}
