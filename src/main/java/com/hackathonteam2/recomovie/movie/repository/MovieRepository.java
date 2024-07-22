package com.hackathonteam2.recomovie.movie.repository;

import com.hackathonteam2.recomovie.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    Movie findByMovieId(Long movieId);
}
