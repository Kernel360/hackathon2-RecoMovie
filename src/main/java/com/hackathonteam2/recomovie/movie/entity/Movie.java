package com.hackathonteam2.recomovie.movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackathonteam2.recomovie.review.entity.Review;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(columnDefinition = "TEXT", name = "overview")
    private String overview;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "poster")
    private String poster;

    @OneToMany(mappedBy = "movie")
    private List<MovieGenre> genres;

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

    @Column(name = "popularity")
    private Double popularity;

    public void addGenre(Genre genre) {
        genres.add(
                MovieGenre.builder()
                        .movie(this)
                        .genre(genre)
                        .build()
        );
    }
}
