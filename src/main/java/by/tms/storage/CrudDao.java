package by.tms.storage;

import org.springframework.stereotype.Component;

@Component
public interface CrudDao<T> {
    T save(T e);
}
