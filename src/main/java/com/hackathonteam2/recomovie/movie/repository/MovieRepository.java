package com.hackathonteam2.recomovie.movie.repository;

import com.hackathonteam2.recomovie.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    Optional<Movie> findByMovieId(Long movieId);

    @Query("SELECT m FROM Movie m WHERE m.title LIKE %:keyword%")
    List<Movie> search(@Param("keyword") String keyword);
}
