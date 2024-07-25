package com.hackathonteam2.recomovie.movie.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class TMDBDetailsDto {

	@JsonProperty("id")
	private Long movie_id;

	private String title;

	private String poster_path;

	private LocalDate release_date;

	private Integer runtime;

	private String overview;
}
