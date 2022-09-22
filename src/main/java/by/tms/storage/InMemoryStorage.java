package by.tms.storage;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface InMemoryStorage<T> extends CrudDao<T> {
    List<T> getElements();
}
