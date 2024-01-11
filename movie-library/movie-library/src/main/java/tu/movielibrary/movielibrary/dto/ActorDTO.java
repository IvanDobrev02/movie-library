package tu.movielibrary.movielibrary.dto;

import tu.movielibrary.movielibrary.model.Movie;
import java.util.Set;

public record ActorDTO (
        String actorName,
        String imageUrl,
        Set<Movie> movies
){
}
