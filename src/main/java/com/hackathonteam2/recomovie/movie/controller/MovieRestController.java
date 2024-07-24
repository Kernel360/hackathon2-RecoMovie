package com.hackathonteam2.recomovie.movie.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathonteam2.recomovie.movie.service.MovieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieRestController {

	private final MovieService movieService;

	// @GetMapping("/search")
	// public List<MovieDto> search(@RequestParam(name = "keyword") String keyword) {
	// 	return movieService.search(keyword);
	// }

}
