package br.com.codenation.mapper;

import br.com.codenation.dto.ApplicationDTO;
import br.com.codenation.mapper.interfaces.EntityMapper;
import br.com.codenation.model.Application;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper extends EntityMapper<Application, ApplicationDTO> {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "token", target = "token"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "updatedAt", target = "updatedAt", dateFormat = "yyyy-MM-dd HH:mm")
    })
    ApplicationDTO toDTO(Application source);

    List<ApplicationDTO> toDTOs(List<Application> sources);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "token", target = "token")
    })
    Application toEntity(ApplicationDTO source);

    List<Application> toEntities(List<ApplicationDTO> sources);

}
