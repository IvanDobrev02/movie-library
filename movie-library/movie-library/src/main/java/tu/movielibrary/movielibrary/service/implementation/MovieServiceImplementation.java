package tu.movielibrary.movielibrary.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tu.movielibrary.dao.MovieDao;
import tu.movielibrary.model.Movie;
import tu.movielibrary.service.MovieService;

import java.util.List;


@Service
public class MovieServiceImplementation implements MovieService {
    @Autowired
    private MovieDao movieDao;

    @Override
    public void saveMovie(Movie movie) {
        movieDao.save(movie);
    }

    @Override
    public List<Movie> getMovies() {
        return movieDao.findAll();
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieDao.delete(movie);
    }

    @Override
    public Movie getMovieById(Long id) throws Exception {
        return movieDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Movie id: " + id));
    }

    public Movie findById(long id){
        return movieDao.findById(id);
    }

    public Movie findByName(String name){
        return  movieDao.findByName(name);
    }

    public List<Movie> findAll(){
        return movieDao.findAll();
    }

}
