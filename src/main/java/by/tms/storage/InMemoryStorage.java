package by.tms.storage;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface InMemoryStorage<T, ID> extends CrudDao<T, ID> {
    List<T> getElements();
    Optional<T> findEntity(String parameter);
}
