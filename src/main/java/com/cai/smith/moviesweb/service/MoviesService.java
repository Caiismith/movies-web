package com.cai.smith.moviesweb.service;

import com.cai.smith.moviesweb.model.Movie;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MoviesService {

    private RestTemplate restTemplate = new RestTemplate();

    public List<Movie> getAllMovies() {
        ResponseEntity<List<Movie>> response = getApiList("http://localhost:8080/movies", HttpMethod.GET);
        return response.getBody();
    }

    public Movie getMostLikedMovie() {
        ResponseEntity<Movie> response = getApi("http://localhost:8080/movies/most-liked", HttpMethod.GET);
        return response.getBody();
    }


    private ResponseEntity<Movie> getApi(String url, HttpMethod method) {
        return restTemplate.exchange(
                url,
                method,
                null,
                new ParameterizedTypeReference<Movie>() {}
        );
    }

    private ResponseEntity<List<Movie>> getApiList(String url, HttpMethod method) {
        return restTemplate.exchange(
                url,
                method,
                null,
                new ParameterizedTypeReference<List<Movie>>() {}
        );
    }
}
