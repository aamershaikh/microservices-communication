package com.aamer.moviecatalogservice.resources;

import com.aamer.moviecatalogservice.models.CatalogItem;
import com.aamer.moviecatalogservice.models.Movie;
import com.aamer.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/catalog")
@RestController
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getcatalog")
    public List<CatalogItem> getCatalog(String userId) {


        // 1. get the ratings - assume that this is the response that is recd from rating data service.
        List<Rating> ratings = Arrays.asList(
                new Rating(1, 4),
                new Rating(2, 3)
        );

        // 2. call the movie info service to get the movie name
        // 3. set the response recd from rating data service and the movie info recd from movie infor service into the catalog item
        return ratings.stream().map(rating -> {
                     Movie movie = restTemplate.getForObject("http://localhost:8082/api/movies/"+rating.getMovieId(), Movie.class);
                     return new CatalogItem(movie.getName(), "test1", rating.getRating());
                }
        ).collect(Collectors.toList());
    }

}
