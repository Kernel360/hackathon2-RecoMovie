package com.hackathonteam2.recomovie.review.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.hackathonteam2.recomovie.review.entity.Review;
import com.hackathonteam2.recomovie.user.entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReviewRequest {

    private String brand;
    private String region;
    private String cinema;
    private String cinemaReview;
    private Long movieId;
    private String movieReview;
    private Integer rating;
}
