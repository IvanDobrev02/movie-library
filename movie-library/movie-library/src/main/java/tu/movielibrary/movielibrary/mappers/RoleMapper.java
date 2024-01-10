package tu.movielibrary.movielibrary.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import tu.movielibrary.movielibrary.dto.RoleDTO;
import tu.movielibrary.movielibrary.model.Role;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {
    @Mapping(target = "roleName", source = "dto.roleName")
    Role convertDtoToEntity(RoleDTO dto, Integer id);
}
