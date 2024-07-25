package com.hackathonteam2.recomovie.movie.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.hackathonteam2.recomovie.movie.dto.TMDBDetailsDto;
import com.hackathonteam2.recomovie.movie.entity.Movie;
import com.hackathonteam2.recomovie.movie.repository.MovieRepository;
import com.hackathonteam2.recomovie.review.dto.ReviewRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {

	private final MovieRepository movieRepository;

	// 저장된거에서 movie id 값으로 찾기 => 그냥 페이지 넘겨주기
	public Movie findByMovieId(Long movieId) {
		return movieRepository.findById(movieId)
			.orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + movieId));
	}

	public TMDBDetailsDto save(ReviewRequest reviewRequest) {
		TMDBDetailsDto tmdbDetailsDto = new TMDBDetailsDto();
		tmdbDetailsDto.setMovie_id(reviewRequest.getMovieId());
		tmdbDetailsDto.setTitle(reviewRequest.getTitle());
		tmdbDetailsDto.setOverview(reviewRequest.getOverview());
		tmdbDetailsDto.setPoster_path(reviewRequest.getPosterPath());
		tmdbDetailsDto.setRelease_date(LocalDate.parse(reviewRequest.getReleaseDate(), DateTimeFormatter.ISO_DATE));
		tmdbDetailsDto.setRuntime(reviewRequest.getRuntime());

		Movie movie = movieRepository.save(parse(tmdbDetailsDto));

		return toDto(movie);
	}

	public Movie parse(TMDBDetailsDto tmdbDetailsDto) {
		return Movie.builder()
			.movieId(tmdbDetailsDto.getMovie_id())
			.title(tmdbDetailsDto.getTitle())
			.overview(tmdbDetailsDto.getOverview())
			.releaseDate(tmdbDetailsDto.getRelease_date())
			.poster(tmdbDetailsDto.getPoster_path())
			.runtime(tmdbDetailsDto.getRuntime())
			.build();
	}

	public TMDBDetailsDto toDto(Movie movie) {
		return TMDBDetailsDto.builder()
			.movie_id(movie.getMovieId())
			.title(movie.getTitle())
			.overview(movie.getOverview())
			.release_date(movie.getReleaseDate())
			.poster_path(movie.getPoster())
			.runtime(movie.getRuntime())
			.build();
	}
}
