package com.hackathonteam2.recomovie.movie.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathonteam2.recomovie.movie.dto.NowPlayingResponse;
import com.hackathonteam2.recomovie.movie.dto.TMDBDetailsDto;
import com.hackathonteam2.recomovie.movie.dto.TMDBNowPlayingDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TMDBService {

	private final RestClient restClient;
	private final ObjectMapper mapper;

	public NowPlayingResponse getNowPlaying(int pageNum) throws JsonProcessingException {
		String json = restClient.get()
			.uri(uriBuilder -> uriBuilder
				.path("3/movie/now_playing")
				.queryParam("language", "ko-KR")
				.queryParam("page", pageNum)
				.queryParam("region", "KR")
				.build())
			.retrieve()
			.body(String.class);

		JsonNode rootNode = mapper.readTree(json);
		List<TMDBNowPlayingDto> nowPlayingDtoList = new ArrayList<>();

		for (JsonNode jsonNode : rootNode.path("results")) {
			TMDBNowPlayingDto nowPlayingDto = TMDBNowPlayingDto.builder()
				.movie_id(jsonNode.path("id").asLong())
				.title(jsonNode.path("title").asText())
				.poster_path(jsonNode.path("poster_path").asText())
				.build();

			nowPlayingDtoList.add(nowPlayingDto);
		}

		NowPlayingResponse nowPlayingResponse = NowPlayingResponse.builder()
			.page(pageNum)
			.totalPage(Integer.valueOf(rootNode.get("total_pages").asText()))
			.totalResults(Integer.valueOf(rootNode.get("total_results").asText()))
			.nowPlaying(nowPlayingDtoList)
			.build();

		return nowPlayingResponse;
	}

	public TMDBDetailsDto getDetails(Long movieId) throws JsonProcessingException {
		String json = restClient.get()
			.uri(uriBuilder -> uriBuilder
				.path("3/movie/" + movieId)
				.queryParam("language", "ko-KR")
				.build())
			.retrieve()
			.body(String.class);

		JsonNode rootNode = mapper.readTree(json);

		TMDBDetailsDto tmdbDetailsDto = TMDBDetailsDto.builder()
			.movie_id(rootNode.path("id").asLong())
			.title(rootNode.path("title").asText())
			.poster_path(rootNode.path("poster_path").asText())
			.release_date(LocalDate.parse(rootNode.path("release_date").asText(), DateTimeFormatter.ISO_DATE))
			.runtime(rootNode.path("runtime").asInt())
			.overview(rootNode.path("overview").asText())
			.build();

		return tmdbDetailsDto;
	}
}
