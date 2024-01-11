package tu.movielibrary.movielibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import tu.movielibrary.movielibrary.model.Actor;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface ActorRepo extends JpaRepository<Actor, Long> {
    Actor findActorById(long UserId);
    Optional<Actor> findActorByActorName(String name);
}
