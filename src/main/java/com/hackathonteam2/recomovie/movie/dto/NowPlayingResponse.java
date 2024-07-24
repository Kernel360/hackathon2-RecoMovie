package com.hackathonteam2.recomovie.movie.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class NowPlayingResponse {

	private Integer page;

	private Integer totalPage;

	private Integer totalResults;

	private List<TMDBNowPlayingDto> nowPlaying;
}
