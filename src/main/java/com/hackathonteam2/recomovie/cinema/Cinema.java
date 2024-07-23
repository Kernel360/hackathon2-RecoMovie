package com.hackathonteam2.recomovie.cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackathonteam2.recomovie.review.entity.Review;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "region")
    private String region;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy ="cinema")
    private List<Review> reviews;

}
