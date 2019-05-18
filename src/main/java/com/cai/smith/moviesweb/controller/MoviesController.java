package com.cai.smith.moviesweb.controller;

import com.cai.smith.moviesweb.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping()
    public String getAllMovies(Model model) {

        model.addAttribute("movies", moviesService.getAllMovies());

        return "movies";
    }

    @GetMapping("/most-liked")
    public String getMostLikedMovie(Model model) {

        model.addAttribute("movies", moviesService.getMostLikedMovie());

        return "movies";
    }
}
