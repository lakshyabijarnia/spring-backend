package com.movies.lalit.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping
       public ResponseEntity<List<Movie>> getallMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{ImdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String ImdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(ImdbId),HttpStatusCode.valueOf(200));
    }
}
