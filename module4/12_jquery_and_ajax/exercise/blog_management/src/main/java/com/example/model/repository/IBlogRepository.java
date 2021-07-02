package com.example.model.repository;

import com.example.model.entity.Blog;
import com.example.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Page<Blog> findAllByTittleContaining(String title, Pageable pageable);
    List<Blog> findAllByTittleContaining(String title);
    @Query(value =
            "select B.id, B.tittle, B.summary, B.content from blog_category BC\n" +
                    "join blog B on B.id = BC.blog_id\n" +
                    "join category C on C.id = BC.category_id " +
                    "where C.id = ?;",nativeQuery = true)
    List<Blog> findAllBlogsByCategory(Long id);
}
