package com.example.homework09.controller;

import com.example.homework09.model.Movie;
import com.example.homework09.repository.MovieRepository;
import com.example.homework09.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    public final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(){
        return ResponseEntity.status(201).body(movieService.getMovies());
    }

    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody @Valid Movie movie, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Movie is add to database");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMovie(@PathVariable String id, @RequestBody Movie movie, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        movieService.updateMovie(id, movie);
        return ResponseEntity.status(200).body("update movie in database");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable String id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("delete movie from database");

    }



}
