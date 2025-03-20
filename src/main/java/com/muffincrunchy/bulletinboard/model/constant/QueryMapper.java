package com.muffincrunchy.bulletinboard.model.constant;

public class QueryMapper {
    public static final String FIND_ALL = "SELECT id, author, password, title, body, views, created_at AS createdAt, updated_at AS updatedAt, deleted_at AS deletedAt FROM posts WHERE deleted_at IS NULL ORDER BY created_at, title";
    public static final String FIND_BY_ID = "SELECT id, author, password, title, body, views, created_at AS createdAt, updated_at AS updatedAt, deleted_at AS deletedAt FROM posts WHERE id = #{id} AND deleted_at IS NULL";
    public static final String FIND_ALL_ORDER_RANK = "WITH order_by_date AS (SELECT * FROM posts WHERE deleted_at IS NULL ORDER BY created_at ASC,title ASC) SELECT ROW_NUMBER() OVER () AS no, id, author, password, title, body, views, created_at AS createdAt, updated_at AS updatedAt, deleted_at AS deletedAt FROM order_by_date";
    public static final String FIND_BY_ID_ORDER_RANK = "WITH order_by_date AS (SELECT * FROM posts WHERE deleted_at IS NULL ORDER BY created_at ASC,title ASC), ranked_order AS (SELECT ROW_NUMBER() OVER () AS no, * FROM order_by_date) SELECT no, id, author, password, title, body, views, created_at AS createdAt, updated_at AS updatedAt, deleted_at AS deletedAt FROM ranked_order WHERE id = #{id}";
}
