package com.cai.smith.moviesweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MoviesController {

    @GetMapping()
    public String getAllMovies() {

        return "movies";
    }
}
