package tu.movielibrary.movielibrary.service;

import tu.movielibrary.movielibrary.model.Actor;

import java.util.List;

public interface ActorService {
    void saveActor(Actor actor);

    List<Actor> getActors();

    void deleteActor(Actor actor);

    Actor getActorById(Long id) throws Exception;

}
