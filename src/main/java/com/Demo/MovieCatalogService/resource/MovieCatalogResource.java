package com.Demo.MovieCatalogService.resource;

import ch.qos.logback.core.net.server.Client;
import com.Demo.MovieCatalogService.model.CatalogItem;
import com.Demo.MovieCatalogService.model.Movie;
import com.Demo.MovieCatalogService.model.Rating;
import com.Demo.MovieCatalogService.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userid}")
    public List<CatalogItem> getUserCatalog(@PathVariable("userid") String userId) {
       UserRating rating =  restTemplate.getForObject("http://ratings-data-service/rating/user/"+userId , UserRating.class);
       return  rating.getListOfRating().stream()
               .map(rating1 -> {
                   Movie movie = restTemplate.getForObject("http://Movie-Info-Service/movies/" +rating1.getMovieId(),Movie.class);
                    return new CatalogItem(movie.getMovieName(), "Good Movie", rating1.getRating());
                 })
                .collect(Collectors.toList());

    }
}

 /*Movie movie =   webClientBuilder.build()
                   .get()
                   .uri("http://localhost:8082/movies/" +rating1.getMovieId() )
                   .retrieve()
                   .bodyToMono(Movie.class)
                   .block();*/
