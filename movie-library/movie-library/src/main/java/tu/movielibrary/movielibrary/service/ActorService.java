package tu.movielibrary.movielibrary.service;

import tu.movielibrary.movielibrary.dto.ActorDTO;
import java.util.List;
public interface ActorService {
    void saveActor(ActorDTO actorDTO);

    List<ActorDTO> getActors();

    void deleteActor(Long actorId);

    ActorDTO getActorById(Long id) throws Exception;
}
