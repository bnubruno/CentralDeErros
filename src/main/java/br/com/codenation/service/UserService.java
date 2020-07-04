package br.com.codenation.service;

import static br.com.codenation.specification.GenericSpecificationBuilder.filterRecords;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.codenation.model.User;
import br.com.codenation.repositories.UserRepository;

@Service
public class UserService extends AbstractService<UserRepository, User, UUID> {

    @Autowired
    public UserService(UserRepository repository) {
        super(repository);
    }

    public void delete(UUID id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            user.get().setActive(false);
            save(user.get());
        }
    }

    public List<User> findWithFilters(Map<Class<?>, Class<?>> params) {
        return repository.findAll(filterRecords(params));
    }
}
