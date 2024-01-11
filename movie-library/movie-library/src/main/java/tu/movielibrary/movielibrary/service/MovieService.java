package tu.movielibrary.movielibrary.service;

import tu.movielibrary.movielibrary.model.Movie;

import java.util.List;

public interface MovieService {
    void saveMovie(Movie movie);

    List<Movie> getMovies();

    void deleteMovie(Movie movie);

    Movie getMovieById(Long id) throws Exception;


}
