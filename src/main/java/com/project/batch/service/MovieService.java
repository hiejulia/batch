package com.project.batch.service;


import java.util.List;

import com.project.batch.model.MovieDetails;
import com.project.batch.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
public class MovieService {

    @Autowired
    private MovieRepository movieRepo;

    public MovieRepository getMovieRepo() {
        return movieRepo;
    }



    public void setMovieRepo(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }


    // Save
    public MovieDetails saveEntity(MovieDetails m) {
        return movieRepo.save(m);
    }


    // Tui no su dung rat nhieu database
    public List<MovieDetails> saveAll (List<MovieDetails> toSave){
        return movieRepo.saveAll(toSave);
    }
}