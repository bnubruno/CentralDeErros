package br.com.codenation.mapper;

import br.com.codenation.dto.UserDTO;
import br.com.codenation.mapper.interfaces.EntityMapper;
import br.com.codenation.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements EntityMapper<User, UserDTO> {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "token", target = "token"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "updatedAt", target = "updatedAt", dateFormat = "yyyy-MM-dd HH:mm")
    })
    public abstract UserDTO toDTO(User user);

    public abstract List<UserDTO> toDTOs(List<User> sources);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "token", target = "token"),
            @Mapping(source = "active", target = "active")
    })
    public abstract User toEntity(UserDTO source);

    public abstract List<User> toEntities(List<UserDTO> sources);
}
