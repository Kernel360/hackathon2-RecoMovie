package com.hackathonteam2.recomovie.movie.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TMDBMovieResponseDto {
    private Boolean adult;
    private String backdrop_path;
    private List<Integer> genre_ids;
    @JsonProperty("id")
    private Integer movie_id;
    private String original_language;
    private String original_title;
    private String overview;
    private Double popularity;
    private String poster_path;
    private String release_date;
    private String title;
    private Boolean video;
    private Double vote_average;
    private Integer vote_count;
}
