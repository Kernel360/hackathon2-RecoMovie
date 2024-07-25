package com.hackathonteam2.recomovie.movie.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackathonteam2.recomovie.review.entity.Review;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

	@Id
	@Column(name = "movie_id")
	private Long movieId;

	@Column(name = "title")
	private String title;

	@Lob
	@Column(columnDefinition = "TEXT", name = "overview")
	private String overview;

	@Column(name = "release_date")
	private LocalDate releaseDate;

	@Column(name = "poster")
	private String poster;

	@JsonIgnore
	@OneToMany(mappedBy = "movie")
	private List<Review> reviews;

	@Column(name = "runtime")
	private Integer runtime;
}