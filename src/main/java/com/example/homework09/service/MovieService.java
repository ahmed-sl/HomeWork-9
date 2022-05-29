package com.example.homework09.service;

import com.example.homework09.model.Movie;
import com.example.homework09.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    public final MovieRepository movieRepository;
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }


    public void updateMovie(String id, Movie movie) {
        Movie newMovie = movieRepository.findById(id).get();
        newMovie.setName(movie.getName());
        newMovie.setGenre(movie.getGenre());
        newMovie.setRating(movie.getRating());
        newMovie.setDuration(movie.getDuration());
        newMovie.setLunchDate(movie.getLunchDate());
        movieRepository.save(newMovie);
    }


    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }
}
