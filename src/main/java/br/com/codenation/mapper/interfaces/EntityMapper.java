package br.com.codenation.mapper.interfaces;

import br.com.codenation.dto.interfaces.IDTO;
import br.com.codenation.model.interfaces.IModel;

import java.util.List;


public interface EntityMapper<T extends IModel, K extends IDTO> {
    K toDTO(T source);
    List<K> toDTOs(List<T> sources);
    T toEntity(K source);
    List<T> toEntities(List<K> sources);
}
