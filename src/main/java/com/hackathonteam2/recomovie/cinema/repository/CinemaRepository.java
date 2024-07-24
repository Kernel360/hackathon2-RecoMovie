package com.hackathonteam2.recomovie.cinema.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathonteam2.recomovie.cinema.entity.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
	Optional<Cinema> findByBrandAndRegionAndName(String brand, String region, String name);
}
