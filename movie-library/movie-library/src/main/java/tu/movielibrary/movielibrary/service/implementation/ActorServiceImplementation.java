package tu.movielibrary.movielibrary.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tu.movielibrary.movielibrary.repositories.ActorRepo;
import tu.movielibrary.movielibrary.model.Actor;
import tu.movielibrary.movielibrary.service.ActorService;

import java.util.List;

@Service
public class ActorServiceImplementation implements ActorService {
    @Autowired
    private ActorRepo actorRepo;

    @Override
    public void saveActor(Actor cast) {
        actorRepo.save(cast);
    }

    @Override
    public List<Actor> getActors() {
        return actorRepo.findAll();
    }

    @Override
    public void deleteActor(Actor actor) {
        actorRepo.delete(actor);
    }

    @Override
    public Actor getActorById(Long id) {

        return actorDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Cast id: " + id));
    }

    public Actor findActorById(long userId){
        return  actorDao.findActorById(userId);
    }

    public Actor findActorByName(String name){
        return actorDao.findActorByActorName(name);
    }

    /*public List<Actor> findAll(){
        return actorDao.findAllByActorName();
    }*/

}
