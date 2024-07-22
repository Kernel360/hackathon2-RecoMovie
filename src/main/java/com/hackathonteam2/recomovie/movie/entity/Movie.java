package com.hackathonteam2.recomovie.movie.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "overview")
    private String overview;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "poster")
    private String poster;

    @OneToMany(mappedBy = "movie")
    private List<MovieGenre> genres;
}
