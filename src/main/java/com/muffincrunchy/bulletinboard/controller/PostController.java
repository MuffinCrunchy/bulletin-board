package com.muffincrunchy.bulletinboard.controller;

import com.muffincrunchy.bulletinboard.model.dto.DeletePostRequest;
import com.muffincrunchy.bulletinboard.model.entity.Post;
import com.muffincrunchy.bulletinboard.model.dto.CreatePostRequest;
import com.muffincrunchy.bulletinboard.model.dto.UpdatePostRequest;
import com.muffincrunchy.bulletinboard.service.PostService;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    //Home Page View
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("posts", postService.findAllOrderRank());
        return "index";
    }

    //Detail Post View
    @GetMapping("/{id}")
    public String detailPost(@PathVariable("id") int id, Model model) {
        //Add views everytime post viewed
        postService.incViews(id);
        model.addAttribute("post", postService.findByIdOrderRank(id));
        return "detail";
    }

    //Create Form View
    @GetMapping("/form")
    public String createForm(Model model) {
        Post request = Post.builder().id(0).build();
        model.addAttribute("request", request);
        return "form";
    }

    //Create/Update API
    @PostMapping("/save")
    public String createPost(@ModelAttribute("form") Post post, Model model) {
        try {
            if (post.getId() == 0) {
                CreatePostRequest request = CreatePostRequest.builder()
                        .author(post.getAuthor())
                        .password(post.getPassword())
                        .title(post.getTitle())
                        .body(post.getBody())
                        .build();
                postService.create(request);
            } else {
                UpdatePostRequest request = UpdatePostRequest.builder()
                        .id(post.getId())
                        .author(post.getAuthor())
                        .password(post.getPassword())
                        .title(post.getTitle())
                        .body(post.getBody())
                        .build();
                postService.update(request);
                return "redirect:/" + post.getId();
            }
            return "redirect:/";
        } catch (ConstraintViolationException e) {
            model.addAttribute("request", post);
            model.addAttribute("error", e.getMessage());
            return "form";
        }
    }

    //Update Form View
    @GetMapping("/form/{id}")
    public String updateForm(@PathVariable("id") int id, Model model) {
        Post post = postService.find(id);
        model.addAttribute("request", post);
        return "form";
    }

    //Delete Form View
    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") int id, Model model) {
        Post post = postService.find(id);
        model.addAttribute("request", post);
        return "delete";
    }

    //Delete API
    @PostMapping("/delete")
    public String deletePost(@ModelAttribute("delete") Post post, Model model) {
        try {
            DeletePostRequest request = DeletePostRequest.builder()
                    .id(post.getId())
                    .password(post.getPassword())
                    .build();
            postService.delete(request);
            return "redirect:/";
        } catch (ConstraintViolationException e) {
            model.addAttribute("request", post);
            model.addAttribute("error", e.getMessage());
            return "delete";
        }

    }
}
