package com.hackathonteam2.recomovie.cinema;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathonteam2.recomovie.cinema.dto.CinemaDto;
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
public class CinemaService {

    private final CinemaRepository cinemaRepository;
    private final ObjectMapper mapper;

    public List<CinemaDto> findAll() {
        return cinemaRepository.findAll().stream()
                .map(CinemaDto::of)
                .toList();
    }

    public List<CinemaDto> init() throws IOException {
        String[] brands = {"CGV", "LOTTE", "MEGA"};
        List<CinemaDto> cinemaList = new ArrayList<>();
        for(String brand : brands) {
            ClassPathResource resource = new ClassPathResource("json/"+brand+".json");
            Path path = Paths.get(resource.getURI());
            String json =  new String(Files.readAllBytes(path));
            cinemaList.addAll(parse(json, brand));
        }
        save(cinemaList);
        return cinemaList;
    }

    private List<CinemaDto> parse(String json, String brand) throws JsonProcessingException {
        List<CinemaDto> cinemaList = new ArrayList<>();
        JsonNode rootNode = mapper.readTree(json);
        for(JsonNode node : rootNode.findPath("Info")) {
            String region = node.get("RegionName").asText();
            for(JsonNode cinema : node.get("Cinemas")) {
                cinemaList.add(new CinemaDto(brand, region, cinema.asText()));
            }
        }
        return cinemaList;
    }

    private void save(List<CinemaDto> cinemaList) {
        cinemaList.stream()
                .map(CinemaDto::toEntity)
                .forEach(cinemaRepository::save);
    }
}
