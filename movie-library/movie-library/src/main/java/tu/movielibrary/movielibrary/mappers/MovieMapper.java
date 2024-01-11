package tu.movielibrary.movielibrary.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import tu.movielibrary.movielibrary.dto.ActorDTO;
import tu.movielibrary.movielibrary.dto.MovieDTO;
import tu.movielibrary.movielibrary.model.Actor;
import tu.movielibrary.movielibrary.model.Movie;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MovieMapper {
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "release_date", source = "dto.release_date")
    @Mapping(target = "rating", source = "dto.rating")
    @Mapping(target = "genre", source = "dto.genre")
    @Mapping(target = "poster", source = "dto.poster")
    @Mapping(target = "description", source = "dto.description")
    Movie convertDtoToEntity(MovieDTO dto, long id);
}
