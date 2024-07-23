package com.hackathonteam2.recomovie.review.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
