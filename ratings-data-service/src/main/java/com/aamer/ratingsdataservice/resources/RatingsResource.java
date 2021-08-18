package com.aamer.ratingsdataservice.resources;

import com.aamer.ratingsdataservice.models.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/ratings")
@RestController
public class RatingsResource {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") int movieId) {
        return new Rating(movieId,4);
    }

}
