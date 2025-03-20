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
//@RestController
//@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("posts", postService.findAllOrderRank());
        return "index";
    }

    @GetMapping("/{id}")
    public String detailPost(@PathVariable("id") int id, Model model) {
        postService.incViews(id);
        model.addAttribute("post", postService.findByIdOrderRank(id));
        return "detail";
    }

    @GetMapping("/form")
    public String createForm(Model model) {
        Post request = Post.builder().id(0).build();
        model.addAttribute("request", request);
        return "form";
    }

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

    @GetMapping("/form/{id}")
    public String updateForm(@PathVariable("id") int id, Model model) {
        Post post = postService.find(id);
        model.addAttribute("request", post);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") int id, Model model) {
        Post post = postService.find(id);
        model.addAttribute("request", post);
        return "delete";
    }

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

//    @GetMapping
//    public ResponseEntity<CommonResponse<List<PostResponse>>> findAll() {
//        List<PostResponse> posts = postService.findAll();
//        CommonResponse<List<PostResponse>> responses = CommonResponse.<List<PostResponse>>builder()
//                .statusCode(HttpStatus.OK.value())
//                .message("success fetch data")
//                .data(posts)
//                .build();
//        return ResponseEntity.ok(responses);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<CommonResponse<PostResponse>> findById(@PathVariable int id) {
//        PostResponse post = postService.findById(id);
//        CommonResponse<PostResponse> response = CommonResponse.<PostResponse>builder()
//                .statusCode(HttpStatus.OK.value())
//                .message("success fetch data")
//                .data(post)
//                .build();
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping
//    public ResponseEntity<CommonResponse<?>> create(@RequestBody CreatePostRequest request) {
//        postService.create(request);
//        CommonResponse<?> response = CommonResponse.builder()
//                .statusCode(HttpStatus.CREATED.value())
//                .message("success create data")
//                .build();
//        return ResponseEntity.ok(response);
//    }
//
//    @PutMapping
//    public ResponseEntity<CommonResponse<?>> update(@RequestBody UpdatePostRequest request) {
//        postService.update(request);
//        CommonResponse<?> response = CommonResponse.builder()
//                .statusCode(HttpStatus.OK.value())
//                .message("success update data")
//                .build();
//        return ResponseEntity.ok(response);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CommonResponse<?>> delete(@PathVariable int id) {
//        postService.delete(id);
//        CommonResponse<?> response = CommonResponse.builder()
//                .statusCode(HttpStatus.OK.value())
//                .message("success delete data")
//                .build();
//        return ResponseEntity.ok(response);
//    }
}
