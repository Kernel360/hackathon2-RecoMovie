package com.hackathonteam2.recomovie.movie.service;

import com.hackathonteam2.recomovie.movie.dto.MovieResponseDto;
import com.hackathonteam2.recomovie.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieResponseDto findByMovieId(Long movieId) {
        return MovieResponseDto.of(movieRepository.findByMovieId(movieId));
    }
}
