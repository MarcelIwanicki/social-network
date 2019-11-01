package com.sharing.overload.controller;

import com.sharing.overload.entity.AppPost;
import com.sharing.overload.entity.AppPostComment;
import com.sharing.overload.service.AppPostCommentService;
import com.sharing.overload.service.AppPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/post")
public class AppPostController {

    @Autowired
    private AppPostService appPostService;

    @Autowired
    private AppPostCommentService appPostCommentService;

    @GetMapping("/{id}")
    public String getPost(@PathVariable long id, Model model) {
        AppPost appPost = appPostService.findAppPostById(id);
        model.addAttribute("appPost", appPost);

        List<AppPostComment> comments = appPostCommentService.findAllByAppPostId(id);
        model.addAttribute("comments", comments);

        return "post";
    }
}
