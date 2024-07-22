package com.hackathonteam2.recomovie.movie.service;

import com.hackathonteam2.recomovie.movie.dto.MovieResponseDto;
import com.hackathonteam2.recomovie.movie.dto.TMDBMovieResponseDto;
import com.hackathonteam2.recomovie.movie.entity.Genre;
import com.hackathonteam2.recomovie.movie.entity.Movie;
import com.hackathonteam2.recomovie.movie.repository.GenreRepository;
import com.hackathonteam2.recomovie.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    public MovieResponseDto addMovie(TMDBMovieResponseDto movieDto) {
        Movie movie = movieDto.toEntity();
        for(Long genreId : movieDto.getGenre_ids()) {
            movie.addGenre(genreRepository.findByGenreId(genreId));
        }
        return MovieResponseDto.of(movieRepository.save(movie));
    }

    public MovieResponseDto findByMovieId(Long movieId) {
        return MovieResponseDto.of(movieRepository.findByMovieId(movieId));
    }
}
