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
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "genre_id")
    private Long genreId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "genre")
    private List<MovieGenre> movies;
}
