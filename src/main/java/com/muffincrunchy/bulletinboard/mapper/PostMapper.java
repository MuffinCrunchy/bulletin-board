package com.muffincrunchy.bulletinboard.mapper;

import com.muffincrunchy.bulletinboard.model.dto.PostQueryResponse;
import com.muffincrunchy.bulletinboard.model.entity.Post;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

import static com.muffincrunchy.bulletinboard.model.constant.QueryMapper.*;

@Mapper
public interface PostMapper {

    @Select(FIND_ALL)
    List<Post> findAll();

    @Select(FIND_BY_ID)
    Post findById(int id);

    @Select(FIND_ALL_ORDER_RANK)
    List<PostQueryResponse> findAllOrderRank();

    @Select(FIND_BY_ID_ORDER_RANK)
    PostQueryResponse findByIdOrderRank(int id);

    @Insert("INSERT INTO posts (author, password, title, body, views, created_at, updated_at, deleted_at) VALUES (#{author}, #{password}, #{title}, #{body}, #{views}, #{createdAt}, #{updatedAt}, #{deletedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Post post);

    @Update("UPDATE posts SET author = #{author}, password = #{password}, title = #{title}, body = #{body}, views = #{views}, updated_at = #{updatedAt} WHERE id = #{id}")
    void update(Post post);

    @Update("UPDATE posts SET deleted_at = #{deletedAt} WHERE id = #{id}")
    void delete(int id, Date deletedAt);

    @Update("UPDATE posts SET views = #{views} WHERE id = #{id}")
    void incViews(int id, int views);
}
