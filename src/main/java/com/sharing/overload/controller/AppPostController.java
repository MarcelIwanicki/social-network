package com.sharing.overload.controller;

import com.sharing.overload.entity.AppPost;
import com.sharing.overload.entity.AppPostComment;
import com.sharing.overload.service.AppPostCommentService;
import com.sharing.overload.service.AppPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post")
public class AppPostController {

    @Autowired
    private AppPostService appPostService;

    @Autowired
    private AppPostCommentService appPostCommentService;

    private long postId;

    @GetMapping("/{id}")
    public String getPost(@PathVariable long id, Model model) {
        this.postId = id;

        AppPost appPost = appPostService.findAppPostById(id);
        model.addAttribute("appPost", appPost);

        List<AppPostComment> comments = appPostCommentService.findAllByAppPostId(id);
        model.addAttribute("comments", comments);

        model.addAttribute("newComment", new AppPostComment());

        return "post";
    }

    @PostMapping("/submit-comment")
    public String submitComment(@ModelAttribute AppPostComment comment) {
        savePostComment(comment);
        return "redirect:/post/" + postId;
    }

    private void savePostComment(AppPostComment comment) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {

            String currentUserName = authentication.getName();
            comment.setAppPostId(postId);
            comment.setUsername(currentUserName);

        }

        appPostCommentService.save(comment);
    }
}
