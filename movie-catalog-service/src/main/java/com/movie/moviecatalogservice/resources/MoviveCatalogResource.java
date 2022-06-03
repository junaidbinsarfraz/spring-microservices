package com.movie.moviecatalogservice.resources;

import com.movie.moviecatalogservice.models.CatalogItem;
import com.movie.moviecatalogservice.models.Movie;
import com.movie.moviecatalogservice.models.Rating;
import com.movie.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MoviveCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public List<CatalogItem> getMovivesCatalog(@PathVariable("userId") String userId) {

        List<Rating> ratings = restTemplate.getForObject("http://RATING-DATA-SERVICE/ratingsdata/foo", UserRating.class).getRatings();

        return ratings.stream().map((rating) -> {
            Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "Movie Desc", rating.getRating());
        })
        .collect(Collectors.toList());
    }

}
