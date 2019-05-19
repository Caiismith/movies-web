package com.cai.smith.moviesweb.service;

import com.cai.smith.moviesweb.model.Comment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommentsService {

    private RestTemplate restTemplate = new RestTemplate();

    public List<Comment> getMostActive() {
        ResponseEntity<List<Comment>> response = getApiList(
                "http://localhost:8080/comments/most-active", HttpMethod.GET);
        return response.getBody();
    }

    private ResponseEntity<List<Comment>> getApiList(String url, HttpMethod method) {
        return restTemplate.exchange(
                url,
                method,
                null,
                new ParameterizedTypeReference<List<Comment>>() {}
        );
    }
}
