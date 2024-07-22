package com.hackathonteam2.recomovie.movie.entity;

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

    public void addGenre(Genre genre) {
        MovieGenre movieGenre = new MovieGenre();
        movieGenre.setMovie(this);
        movieGenre.setGenre(genre);
        genres.add(movieGenre);
    }
}
