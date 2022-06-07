package com.movie.moviecatalogservice.services;

import com.movie.moviecatalogservice.models.Rating;
import com.movie.moviecatalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackRatings")
    public List<Rating> getRatings(@PathVariable("userId") String userId) {
        return restTemplate.getForObject("http://RATING-DATA-SERVICE/ratingsdata/" + userId, UserRating.class).getRatings();
    }

    public List<Rating> getFallbackRatings(@PathVariable("userId") String userId) {
        return Arrays.asList(new Rating(0, "0"));
    }
}
