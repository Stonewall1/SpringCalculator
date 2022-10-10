package by.tms.dao;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface Storage<T, ID> extends CrudDao<T, ID> {
    List<T> getElements();
    Optional<T> findEntity(String parameter);
    T updateEntity(ID id , String param1 , String param2);
}
