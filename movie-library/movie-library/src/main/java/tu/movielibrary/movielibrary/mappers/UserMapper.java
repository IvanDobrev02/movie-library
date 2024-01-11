package tu.movielibrary.movielibrary.mappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import tu.movielibrary.movielibrary.dto.ReviewDTO;
import tu.movielibrary.movielibrary.dto.UserDTO;
import tu.movielibrary.movielibrary.model.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(target = "username", source = "dto.username")
    @Mapping(target = "firstName", source = "dto.firstName")
    @Mapping(target = "lastName", source = "dto.lastName")
    @Mapping(target = "email", source = "dto.email")
    @Mapping(target = "profilePicPath", source = "dto.profilePicPath")
    @Mapping(target = "roleNames", source = "dto.roleNames")
    @Mapping(target = "watchListedMovieIds", source = "dto.watchListedMovieIds")
    @Mapping(target = "favouriteMovieIds", source = "dto.favouriteMovieIds")
    User convertDtoToEntity(UserDTO dto, Long id);

}
