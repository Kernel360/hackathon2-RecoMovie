package com.hackathonteam2.recomovie.movie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hackathonteam2.recomovie.movie.dto.NowPlayingResponse;
import com.hackathonteam2.recomovie.movie.dto.TMDBDetailsDto;
import com.hackathonteam2.recomovie.movie.service.TMDBService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/tmdb")
public class MovieRestController {

	private final TMDBService tmdbService;

	@GetMapping("/nowPlaying")
	public String getNowPlaying(@RequestParam int pageNum) throws JsonProcessingException {
		NowPlayingResponse nowPlayingResponse = tmdbService.getNowPlaying(pageNum);

		return "pageName";
	}

	@GetMapping("/details")
	public String getDetails(@RequestParam Long movieId) throws JsonProcessingException {

		TMDBDetailsDto tmdbDetailsDto = tmdbService.getDetails(movieId);

		return "test";
	}
}
