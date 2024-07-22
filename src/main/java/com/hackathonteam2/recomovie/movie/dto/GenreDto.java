package com.hackathonteam2.recomovie.movie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hackathonteam2.recomovie.movie.entity.Genre;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenreDto {
    @JsonProperty("id")
    private Long genreId;
    private String name;

    public Genre toEntity() {
        return Genre.builder()
                .genreId(genreId)
                .name(name)
                .build();
    }
    public static GenreDto of(Genre genre) {
        return GenreDto.builder()
                .genreId(genre.getGenreId())
                .name(genre.getName())
                .build();
    }
}
