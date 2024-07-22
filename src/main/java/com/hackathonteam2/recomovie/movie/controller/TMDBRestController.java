package com.hackathonteam2.recomovie.movie.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hackathonteam2.recomovie.movie.dto.TMDBMovieResponseDto;
import com.hackathonteam2.recomovie.movie.service.TMDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tmdb")
public class TMDBRestController {

    private final TMDBService tmdbService;

    @GetMapping("/search")
    public List<TMDBMovieResponseDto> search(@RequestParam(name = "keyword") String keyword) throws JsonProcessingException {
        return tmdbService.getByKeyword(keyword);
    }

}
