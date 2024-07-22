package com.hackathonteam2.recomovie;

import com.hackathonteam2.recomovie.review.entity.Review;
import com.hackathonteam2.recomovie.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ReviewService reviewService;

    @GetMapping("/home")
    public String hompage(Model model){
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews",reviews);
        return "home";
    }
}
