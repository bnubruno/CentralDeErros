package br.com.codenation.mapper.interfaces;

import br.com.codenation.model.interfaces.BaseEntity;

import java.util.List;


public interface EntityMapper<E extends BaseEntity, DTO extends br.com.codenation.dto.interfaces.DTO> {

    DTO toDTO(E source);

    List<DTO> toDTOs(List<E> sources);

    E toEntity(DTO source);

    List<E> toEntities(List<DTO> sources);
}
