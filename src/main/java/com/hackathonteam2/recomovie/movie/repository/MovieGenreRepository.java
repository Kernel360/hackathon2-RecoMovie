package com.hackathonteam2.recomovie.movie.repository;

import com.hackathonteam2.recomovie.movie.entity.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieGenreRepository extends JpaRepository<MovieGenre,Long> {
}
