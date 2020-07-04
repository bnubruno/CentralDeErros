package br.com.codenation.service;

import br.com.codenation.model.Application;
import br.com.codenation.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.codenation.specification.GenericSpecificationBuilder.filterRecords;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ApplicationService extends AbstractService<ApplicationRepository, Application, UUID> {

    @Autowired
    public ApplicationService(ApplicationRepository repository) {
        super(repository);
    }

    public List<Application> findWithFilters(Map<Class<?>, Class<?>> params) {
        return repository.findAll(filterRecords(params));
    }
}
