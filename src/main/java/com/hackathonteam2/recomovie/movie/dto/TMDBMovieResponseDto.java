package com.hackathonteam2.recomovie.movie.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class TMDBMovieResponseDto {
	private Boolean adult;
	private String backdrop_path;
	private List<Long> genre_ids;
	@JsonProperty("id")
	private Long movie_id;
	private String original_language;
	private String original_title;
	private String overview;
	private Double popularity;
	private String poster_path;
	private String release_date;
	private String title;
	private Boolean video;
	private Double vote_average;
	private Integer vote_count;

	public Movie toEntity() {
		return Movie.builder()
			.movieId(movie_id)
			.title(title)
			.overview(overview)
			.releaseDate(release_date)
			.poster(poster_path)
			.popularity(popularity)
			.build();
	}
}
