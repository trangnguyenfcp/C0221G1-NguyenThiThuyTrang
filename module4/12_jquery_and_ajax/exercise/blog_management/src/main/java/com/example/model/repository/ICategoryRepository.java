package com.example.model.repository;

import com.example.model.entity.Blog;
import com.example.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category, Long> {
    Page<Category> findAllByNameContaining(String name, Pageable pageable);
    @Query(value =
            "select C.id, C.name from blog_category BC\n" +
                    "join blog B on B.id = BC.blog_id\n" +
                    "join category C on C.id = BC.category_id " +
                    "where B.id = ?;",nativeQuery = true)
    List<Category> findAllCategoriesOfBlog(String id);


}
