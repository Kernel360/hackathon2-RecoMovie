package com.hackathonteam2.recomovie.movie.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathonteam2.recomovie.movie.dto.TMDBMovieResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TMDBService {

    private final RestClient restClient;
    private final ObjectMapper mapper;

    // 반복적인 코드 수정 필요
    public List<TMDBMovieResponseDto> getByKeyword(String keyword) throws JsonProcessingException {
        List<TMDBMovieResponseDto> movieList = new ArrayList<>();
        int page = 1 , totalPages = 0;
        do {
            int pNum = page++;
            String json = restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/3/search/movie")
                            .queryParam("include_adult", "true")
                            .queryParam("language", "ko-KR")
                            .queryParam("page", pNum)
                            .queryParam("query", keyword)
                            .build())
                    .retrieve()
                    .body(String.class);
            JsonNode rootNode = mapper.readTree(json);
            totalPages = Integer.parseInt(rootNode.get("total_pages").asText());
            movieList.addAll(parse(rootNode.findPath("results")));
        } while(page<totalPages);

        return movieList;
    }

    public List<TMDBMovieResponseDto> getByPeriod(String startDate, String endDate) throws JsonProcessingException {

        List<TMDBMovieResponseDto> movieList = new ArrayList<>();
        int page = 1 , totalPages = 0;
        do {
            int pNum = page++;
            String json = restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/3/discover/movie")
                            .queryParam("include_adult", "true")
                            .queryParam("language", "ko-KR")
                            .queryParam("page", pNum)
                            .queryParam("release_date.gte", startDate)
                            .queryParam("release_date.lte", endDate)
                            .queryParam("watch_region", "ko")
                            .build())
                    .retrieve()
                    .body(String.class);
            JsonNode rootNode = mapper.readTree(json);
            totalPages = Integer.parseInt(rootNode.get("total_pages").asText());
            movieList.addAll(parse(rootNode.findPath("results")));
        } while(page<totalPages);

        return movieList;
    }

    private List<TMDBMovieResponseDto> parse(JsonNode nodes) throws JsonProcessingException {
        List<TMDBMovieResponseDto> responseList = new ArrayList<>();
        for (JsonNode node : nodes) {
            responseList.add(mapper.treeToValue(node, TMDBMovieResponseDto.class));
        }
        return responseList;
    }
}
