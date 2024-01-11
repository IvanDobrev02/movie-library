package tu.movielibrary.movielibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import tu.movielibrary.movielibrary.model.Actor;

@Repository
@EnableJpaRepositories
public interface ActorRepo extends JpaRepository<Actor, Long> {
    Actor findActorById(long UserId);

    Actor findActorByActorName(String name);
}
