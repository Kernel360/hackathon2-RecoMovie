package com.hackathonteam2.recomovie.movie.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hackathonteam2.recomovie.movie.dto.MovieResponseDto;
import com.hackathonteam2.recomovie.movie.dto.TMDBMovieResponseDto;
import com.hackathonteam2.recomovie.movie.service.MovieService;
import com.hackathonteam2.recomovie.movie.service.TMDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tmdb")
public class TMDBRestController {

    private final TMDBService tmdbService;
    private final MovieService movieService;

    @GetMapping("/search")
    public  List<MovieResponseDto> search(@RequestParam(name = "keyword") String keyword) throws JsonProcessingException {
        List<TMDBMovieResponseDto> list = tmdbService.getByKeyword(keyword);
        System.out.println("list = " + list);
        return list.stream()
                .map(movieService::addMovie)
                .toList();
    }

}
