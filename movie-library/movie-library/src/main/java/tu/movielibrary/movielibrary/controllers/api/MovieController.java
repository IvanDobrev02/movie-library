package tu.movielibrary.movielibrary.controllers.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tu.movielibrary.movielibrary.dto.ActorDTO;
import tu.movielibrary.movielibrary.dto.MovieDTO;
import tu.movielibrary.movielibrary.mappers.ActorMapper;
import tu.movielibrary.movielibrary.mappers.MovieMapper;
import tu.movielibrary.movielibrary.model.Actor;
import tu.movielibrary.movielibrary.model.Movie;
import tu.movielibrary.movielibrary.service.ActorService;
import tu.movielibrary.movielibrary.service.MovieService;
import tu.movielibrary.movielibrary.service.implementation.movieServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import tu.movielibrary.movielibrary.service.implementation.MovieServiceImplementation;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
@Slf4j
@RestController
@RequiredArgsConstructor
public class MovieController {
    @Autowired
    private MovieServiceImplementation movieService;
    private MovieMapper movieMapper;

    @GetMapping ("/api/get/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getMovies();
        return ResponseEntity.ok(movies);
    }

    @PostMapping("/api/save/movie")
    public ResponseEntity<?> savemovie(@RequestBody MovieDTO dto) {

        Optional<Movie> dbObject = movieService.findByName(dto.name());
        Long id;
        if(dbObject.isPresent()) {
            id = dbObject.get().getId();
            log.info("Updating movie with id {}", id);
        } else {
            id = null;
            log.info("Inserting new movie ");
        }
        Movie movie= movieMapper.convertDtoToEntity(dto, id);

        movieService.saveMovie(movie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/api/delete/movie/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) throws Exception {

        Movie movie = movieService.getMovieById(id);
        movieService.deleteMovie(movie);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}