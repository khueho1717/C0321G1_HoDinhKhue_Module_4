package com.example.manager_movie.model.service;

import com.example.manager_movie.model.entity.Movies;
import com.example.manager_movie.model.repository.IMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MoviesService implements IMoviesService {

    @Autowired
    IMoviesRepository moviesRepository;

    @Override
    public Iterable<Movies> findAll() {
        return moviesRepository.findAll();
    }

    @Override
    public Optional<Movies> findById(int id) {
        return moviesRepository.findById(id);
    }

    @Override
    public void save(Movies movies) {
        moviesRepository.save(movies);
    }

    @Override
    public void remove(int id) {
        moviesRepository.deleteById(id);
    }

    @Override
    public Page<Movies> findAll(Pageable pageable) {
        return moviesRepository.findAll(pageable);
    }
}
