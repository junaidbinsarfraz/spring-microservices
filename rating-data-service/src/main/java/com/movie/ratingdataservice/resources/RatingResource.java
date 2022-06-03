package com.movie.ratingdataservice.resources;

import com.movie.ratingdataservice.models.Rating;
import com.movie.ratingdataservice.models.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

    @GetMapping("/{userId}")
    public UserRating getMovieRating(@PathVariable("userId") String userId) {

        return new UserRating(
                Arrays.asList(
                        new Rating(4, "1324"),
                        new Rating(5, "43534")
                ), userId
        );
    }

}
