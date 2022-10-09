package by.tms.storage;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CrudDao<T, ID> {
    T save(T e);

    Optional<T> findById(ID id);

    T delete(T entity);
}
