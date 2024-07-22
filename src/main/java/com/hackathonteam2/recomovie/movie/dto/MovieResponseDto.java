package com.hackathonteam2.recomovie.movie.dto;

import com.hackathonteam2.recomovie.movie.entity.Movie;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MovieResponseDto {

    @Value("${image_url}")
    private static String imageUrl;

    private Long movieId;
    private String title;
    private String overview;
    private String releaseDate;
    private String poster;
    private List<String> genres;
    public static MovieResponseDto of(Movie movie) {
        return MovieResponseDto.builder()
                .title(movie.getTitle())
                .overview(movie.getOverview())
                .releaseDate(movie.getReleaseDate())
                .poster(imageUrl+movie.getPoster())
                .genres(movie.getGenres().stream()
                        .map(g->g.getGenre().getName())
                        .toList())
                .build();
    }
}
