package by.tms.storage;

import by.tms.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class OperationStorage implements InMemoryStorage<Operation>{
    private final List<Operation> operations = new ArrayList<>();
    @Override
    public Operation save(Operation operation) {
        operations.add(operation);
        return operation;
    }

    @Override
    public List<Operation> getElements() {
        return operations;
    }
}
