package com.hackathonteam2.recomovie.cinema.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackathonteam2.recomovie.review.entity.Review;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
	@OneToMany(mappedBy = "cinema")
	private List<Review> reviews;

}
