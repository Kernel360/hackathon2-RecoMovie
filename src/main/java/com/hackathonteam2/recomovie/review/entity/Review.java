package com.hackathonteam2.recomovie.review.entity;

import com.hackathonteam2.recomovie.cinema.Cinema;
import com.hackathonteam2.recomovie.movie.entity.Movie;
import com.hackathonteam2.recomovie.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "TEXT", nullable = false)
    private String cinemaReview;

    @ManyToOne
    @JoinColumn(name="cinema_id",nullable = false)
    private Cinema cinema;

    @Lob
    @Column(columnDefinition = "TEXT", nullable = false)
    private String movieReview;

    @Column(nullable = false)
    private Integer rating;

    @ManyToOne
    @JoinColumn(name ="user_id",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="movie_id",nullable = false)
    private Movie movie;

}
