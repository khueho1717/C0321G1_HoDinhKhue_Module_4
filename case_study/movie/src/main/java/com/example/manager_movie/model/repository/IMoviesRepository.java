package com.example.manager_movie.model.repository;

import com.example.manager_movie.model.entity.Movies;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMoviesRepository extends PagingAndSortingRepository<Movies,Integer> {
}
