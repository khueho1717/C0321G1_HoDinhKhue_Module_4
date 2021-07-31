package com.example.blogmanager.model.repository;


import com.example.blogmanager.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Page<Blog> findAllByCategoryId(Long id, Pageable pageable);

    Iterable<Blog> findAllByCategoryId(Long id);

    @Query(value = "select *  " +
            "from blogs  join category  on blogs.category_id = category.id " +
            "where blogs.title like %:search% or category.name like %:search% "+
            "order by blogs.date_create",nativeQuery=true)
    Page<Blog> findTitleAndCateId(@Param("search") String search, Pageable pageable);


}
