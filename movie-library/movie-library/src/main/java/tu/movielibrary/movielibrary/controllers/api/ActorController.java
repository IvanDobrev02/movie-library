package tu.movielibrary.movielibrary.controllers.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tu.movielibrary.movielibrary.dto.ActorDTO;
import tu.movielibrary.movielibrary.mappers.ActorMapper;
import tu.movielibrary.movielibrary.model.Actor;
import tu.movielibrary.movielibrary.model.Movie;
import tu.movielibrary.movielibrary.service.ActorService;
import tu.movielibrary.movielibrary.service.MovieService;
import tu.movielibrary.movielibrary.service.implementation.ActorServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
@Slf4j
@RestController
@RequiredArgsConstructor
public class ActorController {

    @Autowired
    private ActorServiceImplementation actorService;
    private ActorMapper actorMapper;

    @GetMapping ("/api/get/actors")
    public ResponseEntity<List<Actor>> getAllActors() {
        List<Actor> actors = actorService.getActors();
        return ResponseEntity.ok(actors);
    }

    @PostMapping("/api/save/actor")
    public ResponseEntity<?> saveActor(@RequestBody ActorDTO dto) {

        Optional<Actor> dbObject = actorService.findActorByName(dto.actorName());
        Long id;
        if(dbObject.isPresent()) {
            id = dbObject.get().getId();
            log.info("Updating Actor with id {}", id);
        } else {
            id = null;
            log.info("Inserting new Actor ");
        }
        Actor actor= actorMapper.convertDtoToEntity(dto, id);

        actorService.saveActor(actor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/api/delete/actor/{id}")
    public ResponseEntity<?> deleteActor(@PathVariable Long id) {

        Actor actor = actorService.getActorById(id);
        actorService.deleteActor(actor);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
