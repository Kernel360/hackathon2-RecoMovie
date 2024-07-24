package com.hackathonteam2.recomovie.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hackathonteam2.recomovie.movie.dto.MovieResponseDto;
import com.hackathonteam2.recomovie.movie.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {

	private final MovieRepository movieRepository;

	public List<MovieResponseDto> search(String keyword) {
		return movieRepository.search(keyword).stream()
			.map(MovieResponseDto::of)
			.sorted((i, j) -> Double.compare(j.getPopularity(), i.getPopularity()))
			.toList();
	}

	public Boolean isExist(Long movieId) {
		return movieRepository.findByMovieId(movieId).isPresent();
	}
}
