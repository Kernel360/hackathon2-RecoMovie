package com.hackathonteam2.recomovie.admin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hackathonteam2.recomovie.cinema.CinemaService;
import com.hackathonteam2.recomovie.movie.dto.MovieResponseDto;
import com.hackathonteam2.recomovie.movie.dto.TMDBMovieResponseDto;
import com.hackathonteam2.recomovie.movie.entity.Movie;
import com.hackathonteam2.recomovie.movie.service.GenreService;
import com.hackathonteam2.recomovie.movie.service.MovieService;
import com.hackathonteam2.recomovie.movie.service.TMDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class adminRestController {

    private final CinemaService cinemaService;
    private final GenreService genreService;
    private final TMDBService tmdbService;
    private final MovieService movieService;

    @PostMapping("/init")
    public ResponseEntity<?> init() throws IOException {

        cinemaService.init();
        genreService.init();

        return ResponseEntity.ok()
                .body("영화관, 장르 기본정보 db 저장 완료");
    }

    @PostMapping("/save-in-period")
    public ResponseEntity<?> save(
            @RequestParam("start_date") String startDate,
            @RequestParam("end_date") String endDate) throws JsonProcessingException {
        System.out.println("startDate = " + startDate);
        System.out.println("endDate = " + endDate);
//        List<TMDBMovieResponseDto> newMovieList = tmdbService.getByPeriod(startDate, endDate);
//        List<MovieResponseDto> list = newMovieList.stream()
//                .filter(m -> !movieService.isExist(m.getMovie_id()))
//                .map(movieService::addMovieFromTMDB)
//                .toList();
        return ResponseEntity.ok().body("asdf");//list);
    }
}
