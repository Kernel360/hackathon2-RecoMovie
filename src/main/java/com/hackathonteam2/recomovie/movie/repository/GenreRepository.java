package com.hackathonteam2.recomovie.movie.repository;

import com.hackathonteam2.recomovie.movie.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
    Genre findByGenreId(Long genreId);
}
