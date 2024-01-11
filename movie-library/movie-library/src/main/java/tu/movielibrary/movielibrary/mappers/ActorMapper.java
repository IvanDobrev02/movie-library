package tu.movielibrary.movielibrary.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import tu.movielibrary.movielibrary.dto.ActorDTO;
import tu.movielibrary.movielibrary.model.Actor;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ActorMapper {
    @Mapping(target = "actorName", source = "dto.actorName")
    @Mapping(target = "imageUrl", source = "dto.imageUrl")
    @Mapping(target = "movies", source = "dto.movies")
    Actor convertDtoToEntity(ActorDTO dto, long id);
}
