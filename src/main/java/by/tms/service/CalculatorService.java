package by.tms.service;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.storage.OperationStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CalculatorService {

    private OperationStorage operationStorage;

    @Autowired
    public CalculatorService(OperationStorage operationStorage) {
        this.operationStorage = operationStorage;
    }

    public Operation calculate(Operation operation , User user) {
        double result = 0;
        switch (operation.getOperation()) {
            case "sum" -> result = operation.getX1() + operation.getX2();
            case "sub" -> result = operation.getX1() - operation.getX2();
            case "mul" -> result = operation.getX1() * operation.getX2();
            case "div" -> result = operation.getX1() / operation.getX2();
            default -> {
            }
        }
        operation.setUser(user);
        operation.setResult(result);
        operation.setTime(LocalDateTime.now());
        return operationStorage.save(operation);
    }

    public List<Operation> getOperations() {
        return operationStorage.getElements();
    }

    public List<Operation> getOperationsByUser(User user) {
        List<Operation> ops = new ArrayList<>();
        for (Operation operation : getOperations()) {
            if (operation.getUser().getId() == user.getId()) {
                ops.add(operation);
            }
        }
        return ops;
    }
}
