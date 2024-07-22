package com.hackathonteam2.recomovie.movie.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathonteam2.recomovie.cinema.dto.CinemaDto;
import com.hackathonteam2.recomovie.movie.dto.GenreDto;
import com.hackathonteam2.recomovie.movie.dto.TMDBMovieResponseDto;
import com.hackathonteam2.recomovie.movie.entity.Genre;
import com.hackathonteam2.recomovie.movie.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;
    private final ObjectMapper mapper;
    public Genre findByGenreId(Long genreId) {
        return genreRepository.findByGenreId(genreId);
    }

    public List<GenreDto> init() throws IOException {
        ClassPathResource resource = new ClassPathResource("json/Genre.json");
        Path path = Paths.get(resource.getURI());
        String json =  new String(Files.readAllBytes(path));
        List<GenreDto> genreList = parse(json);
        save(genreList);
        return genreList;
    }

    private List<GenreDto> parse(String json) throws JsonProcessingException {
        List<GenreDto> genreList = new ArrayList<>();
        JsonNode rootNode = mapper.readTree(json);
        for(JsonNode node : rootNode.findPath("genres")) {
            genreList.add(mapper.treeToValue(node, GenreDto.class));
        }
        return genreList;
    }

    private void save(List<GenreDto> genreList) {
        genreList.stream()
                .map(GenreDto::toEntity)
                .forEach(genreRepository::save);
    }
}
