package com.cai.smith.moviesweb.controller;

import com.cai.smith.moviesweb.model.Comment;
import com.cai.smith.moviesweb.model.Movie;
import com.cai.smith.moviesweb.service.EpochDateService;
import com.cai.smith.moviesweb.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @Autowired
    private EpochDateService epochDateService;

    private static final String MOVIES_MODEL_ATTR_NAME = "movies";
    private static final String COMMENTS_MODEL_ATTR_NAME = "comments";

    @GetMapping()
    public String getAllMovies(Model model) {

        model.addAttribute(MOVIES_MODEL_ATTR_NAME, moviesService.getAllMovies());

        return "movies";
    }

    @GetMapping("/most-liked")
    public String getMostLikedMovie(Model model) {

        model.addAttribute(MOVIES_MODEL_ATTR_NAME, moviesService.getMostLikedMovie());

        return "movies";
    }

    @GetMapping("/id/{movieId}")
    public String getMovieByTitle(Model model, @PathVariable int movieId) {

        Movie movie = moviesService.getMovieByMovieId(movieId);
        List<Comment> comments = movie.getComments();

        for(Comment comment: comments) {
            Long seconds = Long.parseLong(comment.getDateCreated());

            comment.setDateHumanReadable(epochDateService.convertToReadable(seconds));
        }

        model.addAttribute(MOVIES_MODEL_ATTR_NAME, movie);
        model.addAttribute(COMMENTS_MODEL_ATTR_NAME, comments);

        return "movieProfile";
    }
}
