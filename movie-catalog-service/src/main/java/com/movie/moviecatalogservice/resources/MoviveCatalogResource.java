package com.movie.moviecatalogservice.resources;

import com.movie.moviecatalogservice.models.CatalogItem;
import com.movie.moviecatalogservice.models.Movie;
import com.movie.moviecatalogservice.models.Rating;
import com.movie.moviecatalogservice.models.UserRating;
import com.movie.moviecatalogservice.services.CatalogItemService;
import com.movie.moviecatalogservice.services.RatingService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MoviveCatalogResource {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private CatalogItemService catalogItemService;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        List<Rating> ratings = this.ratingService.getRatings(userId);

        return ratings.stream().map((rating) -> {
            return this.catalogItemService.getCatalogItem(rating);
        })
        .collect(Collectors.toList());
    }

}
