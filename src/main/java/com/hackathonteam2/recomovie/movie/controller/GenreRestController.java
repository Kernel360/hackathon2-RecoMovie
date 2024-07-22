package com.hackathonteam2.recomovie.movie.controller;

import com.hackathonteam2.recomovie.movie.dto.GenreDto;
import com.hackathonteam2.recomovie.movie.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/genre")
public class GenreRestController {
    private final GenreService genreService;

    @GetMapping("/init")
    public List<GenreDto> init() throws IOException {
        return genreService.init();
    }
}
