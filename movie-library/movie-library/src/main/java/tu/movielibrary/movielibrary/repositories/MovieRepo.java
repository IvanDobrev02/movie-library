package tu.movielibrary.movielibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import tu.movielibrary.movielibrary.model.Movie;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface MovieRepo extends JpaRepository<Movie, Long> {
    Movie findById(long movieId);
    Movie findByName(String name);

    List<Movie> findAll();


}