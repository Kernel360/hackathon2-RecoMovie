package com.hackathonteam2.recomovie.cinema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Long> {
    Optional<Cinema> findByBrandAndRegionAndName(String brand, String region, String name);
}
