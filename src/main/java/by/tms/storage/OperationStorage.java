package by.tms.storage;

import by.tms.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("OperationStorage")
public class OperationStorage implements InMemoryStorage<Operation , Long> {
    private final List<Operation> operations = new ArrayList<>();

    @Override
    public Operation save(Operation operation) {
        operations.add(operation);
        return operation;
    }

    @Override
    public Optional<Operation> findById(Long id) {
        return operations.stream().filter(operation -> operation.getId() ==id).findFirst();
    }
    /**
     * toDO
     * @param entity
     * @return
     */
    @Override
    public Operation delete(Operation entity) {
        return null;
    }

    @Override
    public List<Operation> getElements() {
        return operations;
    }

    @Override
    public Optional<Operation> findEntity(String parameter) {
        return operations.stream().filter(operation -> operation.getId() == Integer.parseInt(parameter)).findFirst();
    }
}
