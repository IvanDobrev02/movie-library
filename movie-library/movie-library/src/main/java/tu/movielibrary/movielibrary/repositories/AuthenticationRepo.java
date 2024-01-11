package tu.movielibrary.movielibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import tu.movielibrary.movielibrary.model.User;

@Repository
@EnableJpaRepositories
public interface AuthenticationRepo extends JpaRepository<User, Long> {

}
