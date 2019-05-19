package com.cai.smith.moviesweb.controller;

import com.cai.smith.moviesweb.model.Comment;
import com.cai.smith.moviesweb.service.CommentsService;
import com.cai.smith.moviesweb.service.EpochDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private EpochDateService epochDateService;

    private static final String COMMENTS_MODEL_ATTR_NAME = "comments";

    @GetMapping("most-active")
    public String getMostActive(Model model) {

        List<Comment> comments = commentsService.getMostActive();

        for(Comment comment: comments) {
            Long seconds = Long.parseLong(comment.getDateCreated());

            comment.setDateHumanReadable(epochDateService.convertToReadable(seconds));
        }

        model.addAttribute(COMMENTS_MODEL_ATTR_NAME, comments);

        return "mostActive";
    }
}
