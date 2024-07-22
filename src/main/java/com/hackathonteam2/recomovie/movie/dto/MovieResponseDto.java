package com.hackathonteam2.recomovie.movie.dto;

import com.hackathonteam2.recomovie.movie.entity.Movie;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MovieResponseDto {

    private Long movieId;

    public static MovieResponseDto of(Movie byMovieId) {
        return MovieResponseDto.builder()
                .build();
    }
}
