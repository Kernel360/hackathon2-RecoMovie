package com.hackathonteam2.recomovie.movie.service;

import org.springframework.stereotype.Service;

import com.hackathonteam2.recomovie.movie.entity.Movie;
import com.hackathonteam2.recomovie.movie.repository.MovieRepository;

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
}
