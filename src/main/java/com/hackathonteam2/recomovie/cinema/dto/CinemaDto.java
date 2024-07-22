package com.hackathonteam2.recomovie.cinema.dto;


import com.hackathonteam2.recomovie.cinema.Cinema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CinemaDto {

    private String brand;

    private String region;

    private String name;

    public Cinema toEntity() {
        return Cinema.builder()
                .brand(this.brand)
                .region(this.region)
                .name(this.name)
                .build();
    }

    public static CinemaDto of(Cinema cinema) {
        return CinemaDto.builder()
                .brand(cinema.getBrand())
                .region(cinema.getRegion())
                .name(cinema.getName())
                .build();
    }
}
