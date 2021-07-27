package com.blog.model.repository;

import com.blog.model.entity.Blog;
import com.blog.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Page<Blog> findAllByCategoryId(Long id, Pageable pageable);

    Iterable<Blog> findAllByCategoryId(Long id);

    @Query(value = "select b.title,b.summary,c.name  " +
            "from blogs b inner join category c on b.category_id = c.id " +
            "where b.title like %:search% and c.name like %:search% ",nativeQuery=true)
    Page<Blog> findTitleAndCateId(@Param("search") String search, Pageable pageable);


}
