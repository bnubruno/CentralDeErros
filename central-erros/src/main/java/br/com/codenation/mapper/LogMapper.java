package br.com.codenation.mapper;

import br.com.codenation.dto.LogDTO;
import br.com.codenation.mapper.interfaces.IMapper;
import br.com.codenation.model.Error;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class LogMapper implements IMapper<Error, LogDTO> {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "details", target = "details"),
            @Mapping(source = "application.id", target = "applicationId"),
            @Mapping(source = "application.name", target = "applicationName"),
            @Mapping(source = "archived", target = "archived"),
            @Mapping(source = "user.id", target = "userId"),
            @Mapping(source = "user.name", target = "userName"),
            @Mapping(source = "level", target = "level"),
            @Mapping(source = "environment", target = "environment"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "updatedAt", target = "updatedAt", dateFormat = "yyyy-MM-dd HH:mm")
    })
    public abstract LogDTO toDTO(Error source);

    public abstract List<LogDTO> toDTOs(List<Error> sources);

}
