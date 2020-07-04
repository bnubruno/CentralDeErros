package br.com.codenation.mapper;

import br.com.codenation.dto.LogDTO;
import br.com.codenation.mapper.interfaces.EntityMapper;
import br.com.codenation.model.Error;
import br.com.codenation.service.ApplicationService;
import br.com.codenation.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ApplicationService.class, UserService.class })
public abstract class LogMapper implements EntityMapper<Error, LogDTO> {

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
            @Mapping(source = "events", target = "events"),
            @Mapping(source = "environment", target = "environment"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "updatedAt", target = "updatedAt", dateFormat = "yyyy-MM-dd HH:mm")
    })
    public abstract LogDTO toDTO(Error source);

    public abstract List<LogDTO> toDTOs(List<Error> sources);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "details", target = "details"),
            @Mapping(source = "applicationId", target = "application"),
            @Mapping(source = "archived", target = "archived"),
            @Mapping(source = "userId", target = "user"),
            @Mapping(source = "level", target = "level"),
            @Mapping(source = "events", target = "events"),
            @Mapping(source = "environment", target = "environment")
    })
    public abstract Error toEntity(LogDTO source);

    public abstract List<Error> toEntities(List<LogDTO> sources);

}
