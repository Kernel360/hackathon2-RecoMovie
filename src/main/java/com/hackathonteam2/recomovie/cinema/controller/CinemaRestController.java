package com.hackathonteam2.recomovie.cinema.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathonteam2.recomovie.cinema.dto.CinemaDto;
import com.hackathonteam2.recomovie.cinema.service.CinemaService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/cinema")
@RestController
@RequiredArgsConstructor
public class CinemaRestController {

	private final CinemaService cinemaService;

	@GetMapping("/init")
	public String init() throws IOException {
		return cinemaService.init().toString();
	}

	@GetMapping("/list")
	public List<CinemaDto> list() {
		return cinemaService.findAll();
	}
}
