package com.hackathonteam2.recomovie.cinema.controller;

import com.hackathonteam2.recomovie.cinema.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cinema")
@RequiredArgsConstructor
public class CinemaController {

    private final CinemaService cinemaService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("cinemaList", cinemaService.findAll());
        return "cinemaList";
    }
}
