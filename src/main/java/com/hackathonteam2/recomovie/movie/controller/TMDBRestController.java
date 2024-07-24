package com.hackathonteam2.recomovie.movie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hackathonteam2.recomovie.movie.dto.NowPlayingResponse;
import com.hackathonteam2.recomovie.movie.dto.TMDBDetailsDto;
import com.hackathonteam2.recomovie.movie.service.MovieService;
import com.hackathonteam2.recomovie.movie.service.TMDBService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/tmdb")
public class TMDBRestController {

	private final TMDBService tmdbService;
	private final MovieService movieService;

	// 기존 search 기능 사용 안함으로 주석 처리 (추후 삭제 필요)
	// @GetMapping("/search")
	// public  List<MovieResponseDto> search(@RequestParam(name = "keyword") String keyword) throws JsonProcessingException {
	//     List<TMDBMovieResponseDto> list = tmdbService.getByKeyword(keyword);
	//     return list.stream()
	//             .map(movieService::addMovieFromTMDB)
	//             .toList();
	// }

	// @GetMapping("/get-all-data")
	// public String getAllData() throws JsonProcessingException {
	// 	return tmdbService.getByPeriod("2024-01-15", "2024-01-15").toString();
	// }

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
