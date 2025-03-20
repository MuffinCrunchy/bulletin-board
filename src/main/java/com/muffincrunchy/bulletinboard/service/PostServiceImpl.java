package com.muffincrunchy.bulletinboard.service;

import com.muffincrunchy.bulletinboard.mapper.PostMapper;
import com.muffincrunchy.bulletinboard.model.dto.*;
import com.muffincrunchy.bulletinboard.model.entity.Post;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;

    @Override
    public List<PostResponse> findAllOrderRank() {
        List<PostQueryResponse> posts = postMapper.findAllOrderRank();
        return posts.stream().map(post -> {
            return PostResponse.builder()
                    .no(post.getNo())
                    .id(post.getId())
                    .author(post.getAuthor())
                    .title(post.getTitle())
                    .body(post.getBody())
                    .views(post.getViews())
                    .createdAt(post.getCreatedAt())
                    .updatedAt(post.getUpdatedAt())
                    .build();
        }).toList();
    }

    @Override
    public PostResponse findByIdOrderRank(int id) {
        PostQueryResponse post = postMapper.findByIdOrderRank(id);
        return PostResponse.builder()
                .no(post.getNo())
                .id(post.getId())
                .author(post.getAuthor())
                .title(post.getTitle())
                .body(post.getBody())
                .views(post.getViews())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    @Override
    public Post find(int id) {
        return postMapper.findById(id);
    }

    @Override
    public void create(CreatePostRequest request) {
        // Name Rules
        if (hangulMatcher(request.getAuthor())) {
            if (request.getAuthor().length() > 10) {
                throw new ConstraintViolationException("name only contain up to 10 characters in Korean", null);
            }
        } else {
            if (request.getAuthor().length() > 50) {
                throw new ConstraintViolationException("name only contain up to 50 characters in English", null);
            }
        }
        if (isNameInvalid(request.getAuthor())) {
            throw new ConstraintViolationException("name should not contain special characters or numbers", null);
        }

        //Title Rules
        if (hangulMatcher(request.getTitle())) {
            if (request.getTitle().length() > 50) {
                throw new ConstraintViolationException("titles only contain up to 50 characters in Korean", null);
            }
        } else {
            if (request.getTitle().length() > 100) {
                throw new ConstraintViolationException("titles only contain up to 100 characters in English", null);
            }
        }

        //Password Rules
        if (request.getPassword().length() < 6) {
            throw new ConstraintViolationException("password at least 6 characters", null);
        }
        if (request.getPassword().length() > 64) {
            throw new ConstraintViolationException("password only contain up to 100 characters", null);
        }
        if (!isPasswordValid(request.getPassword())) {
            throw new ConstraintViolationException("password should only contain latin letters, numbers, and special characters", null);
        }

        Post post = Post.builder()
                .author(request.getAuthor())
                .password(request.getPassword())
                .title(request.getTitle())
                .title(request.getTitle())
                .body(request.getBody())
                .views(0)
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .updatedAt(new Timestamp(System.currentTimeMillis()))
                .deletedAt(null)
                .build();
        postMapper.insert(post);
    }

    @Override
    public void update(UpdatePostRequest request) {
        //Name Rules
        if (hangulMatcher(request.getAuthor())) {
            if (request.getAuthor().length() > 10) {
                throw new ConstraintViolationException("name only contain up to 10 characters in Korean", null);
            }
        } else {
            if (request.getAuthor().length() > 50) {
                throw new ConstraintViolationException("name only contain up to 50 characters in English", null);
            }
        }
        if (isNameInvalid(request.getAuthor())) {
            throw new ConstraintViolationException("name should not contain special characters or number", null);
        }

        //Title Rules
        if (hangulMatcher(request.getTitle())) {
            if (request.getTitle().length() > 50) {
                throw new ConstraintViolationException("titles only contain up to 50 characters in Korean", null);
            }
        } else {
            if (request.getTitle().length() > 100) {
                throw new ConstraintViolationException("titles only contain up to 100 characters in English", null);
            }
        }

        //Password Rules
        if (request.getPassword().length() > 64) {
            throw new ConstraintViolationException("password only contain up to 100 characters", null);
        }
        if (!isPasswordValid(request.getPassword())) {
            throw new ConstraintViolationException("password should only contain latin letters, numbers, and special characters", null);
        }


        Post post = postMapper.findById(request.getId());
        if (!post.getPassword().equals(request.getPassword())) {
            throw new ConstraintViolationException("password doesn't match", null);
        }

        post.setAuthor(request.getAuthor());
        post.setTitle(request.getTitle());
        post.setBody(request.getBody());
        post.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        postMapper.update(post);
    }

    @Override
    public void delete(DeletePostRequest request) {
        Post post = postMapper.findById(request.getId());
        if (!post.getPassword().equals(request.getPassword())) {
            throw new ConstraintViolationException("password doesn't match", null);
        }
        postMapper.delete(post.getId(), new Date());
    }

    //Add Views
    @Override
    public void incViews(int id) {
        Post post = find(id);
        postMapper.incViews(id, post.getViews()+1);
    }

    //Utilities Function
    private boolean hangulMatcher(String str) {
        Pattern pattern = Pattern.compile("[\u1100-\u11FF|\u3130-\u318F|\uA960-\uA97F|\uAC00-\uD7AF|\uD7B0-\uD7FF]");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    private boolean isNameInvalid(String str) {
        Pattern pattern = Pattern.compile(".*[0-9\\p{Punct}].*");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    private boolean isPasswordValid(String str) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\p{Punct}]+$");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}
