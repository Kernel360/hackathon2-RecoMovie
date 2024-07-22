package com.hackathonteam2.recomovie.review.controller;

import com.hackathonteam2.recomovie.review.service.ReviewService;
import com.hackathonteam2.recomovie.user.entity.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;


    @GetMapping("/reviews")
    public String showReviewForm(){
        return "review_form";
    }

    @PostMapping("reviews/write")
    public String writeReview(
            @RequestParam String content,
            @RequestParam int rating
    , HttpSession httpSession){
        User user = (User) httpSession.getAttribute("loggedInUser");
        if(user != null){
            String loginId = user.getLoginId();
            reviewService.writeReview(loginId,content,rating);
            return "redirect:/home";
        } else {
            return "redirect:/login?error";
        }
    }
}
