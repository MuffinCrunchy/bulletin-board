package com.muffincrunchy.bulletinboard.mapper;

import com.muffincrunchy.bulletinboard.model.dto.PostQueryResponse;
import com.muffincrunchy.bulletinboard.model.entity.Post;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

import static com.muffincrunchy.bulletinboard.model.constant.QueryMapper.*;

@Mapper
public interface PostMapper {

    //Query Select All Default
    @Select(FIND_ALL)
    List<Post> findAll();

    //Query Select by Id Default
    @Select(FIND_BY_ID)
    Post findById(int id);

    //Query Select All with Rank Order
    @Select(FIND_ALL_ORDER_RANK)
    List<PostQueryResponse> findAllOrderRank();

    //Query Select by Id with Rank Order
    @Select(FIND_BY_ID_ORDER_RANK)
    PostQueryResponse findByIdOrderRank(int id);

    //Query Insert
    @Insert("INSERT INTO posts (author, password, title, body, views, created_at, updated_at, deleted_at) VALUES (#{author}, #{password}, #{title}, #{body}, #{views}, #{createdAt}, #{updatedAt}, #{deletedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Post post);

    //Query Update
    @Update("UPDATE posts SET author = #{author}, password = #{password}, title = #{title}, body = #{body}, views = #{views}, updated_at = #{updatedAt} WHERE id = #{id}")
    void update(Post post);

    //Query Delete (Remove from List not DB)
    @Update("UPDATE posts SET deleted_at = #{deletedAt} WHERE id = #{id}")
    void delete(int id, Date deletedAt);

    //Query Update Views
    @Update("UPDATE posts SET views = #{views} WHERE id = #{id}")
    void incViews(int id, int views);
}
