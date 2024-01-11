package tu.movielibrary.movielibrary.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tu.movielibrary.movielibrary.repositories.MovieRepo;
import tu.movielibrary.movielibrary.model.Movie;
import tu.movielibrary.movielibrary.service.MovieService;

import java.util.List;
import java.util.Optional;


@Service
public class MovieServiceImplementation implements MovieService {
    @Autowired
    private MovieRepo movieRepo;

    @Override
    public void saveMovie(Movie movie) {
        movieRepo.save(movie);
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepo.findAll();
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieRepo.delete(movie);
    }

    @Override
    public Movie getMovieById(Long id) throws Exception {
        return movieRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Movie id: " + id));
    }

    public Movie findById(long id){
        return movieRepo.findById(id);
    }

    public Optional<Movie> findByName(String name){
        return  movieRepo.findByName(name);
    }

    public List<Movie> findAll(){
        return movieRepo.findAll();
    }

}
