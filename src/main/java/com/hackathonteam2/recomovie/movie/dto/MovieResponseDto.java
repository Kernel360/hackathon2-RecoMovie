package com.hackathonteam2.recomovie.movie.dto;

import java.util.List;

import com.hackathonteam2.recomovie.movie.entity.Movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MovieResponseDto {

	private final static String imageUrl = "https://image.tmdb.org/t/p/original/";

	private Long movieId;
	private String title;
	private String overview;
	private String releaseDate;
	private String poster;
	private List<String> genres;
	private Double popularity;

	public static MovieResponseDto of(Movie movie) {
		return MovieResponseDto.builder()
			.movieId(movie.getMovieId())
			.title(movie.getTitle())
			.overview(movie.getOverview())
			.releaseDate(movie.getReleaseDate())
			.poster(imageUrl + movie.getPoster())
			.popularity(movie.getPopularity())
			.build();
	}
}
