package com.example.manager_movie.model.service;

import com.example.manager_movie.model.entity.Movies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface IMoviesService {

    Iterable<Movies> findAll();

    Optional<Movies> findById(int id);

    void save(Movies movies);

    void remove(int id);

    Page<Movies> findAll(Pageable pageable);
}
