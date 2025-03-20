package com.muffincrunchy.bulletinboard.service;

import com.muffincrunchy.bulletinboard.model.dto.CreatePostRequest;
import com.muffincrunchy.bulletinboard.model.dto.DeletePostRequest;
import com.muffincrunchy.bulletinboard.model.dto.PostResponse;
import com.muffincrunchy.bulletinboard.model.dto.UpdatePostRequest;
import com.muffincrunchy.bulletinboard.model.entity.Post;

import java.util.List;

public interface PostService {

    List<PostResponse> findAllOrderRank();
    PostResponse findByIdOrderRank(int id);
    Post find(int id);
    void create(CreatePostRequest request);
    void update(UpdatePostRequest request);
    void delete(DeletePostRequest request);
    void incViews(int id);
}
