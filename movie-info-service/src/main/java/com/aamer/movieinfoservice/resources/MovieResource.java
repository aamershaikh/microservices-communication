package com.aamer.movieinfoservice.resources;

import com.aamer.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/movies")
@RestController
public class MovieResource {

    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") int movieId) {
        return new Movie(movieId, "TestMovie123");
    }

}
