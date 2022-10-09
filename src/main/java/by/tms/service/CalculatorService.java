package by.tms.service;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.storage.InMemoryStorage;
import by.tms.storage.OperationStorage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CalculatorService {
    @Qualifier("OperationStorage")
    private final InMemoryStorage<Operation, Long> operationStorage;

    public CalculatorService(OperationStorage operationStorage) {
        this.operationStorage = operationStorage;
    }

    public Operation calculate(Operation operation, User user) {
        double result = 0;
        switch (operation.getOperation()) {
            case "sum" -> result = operation.getX1() + operation.getX2();
            case "sub" -> result = operation.getX1() - operation.getX2();
            case "mul" -> result = operation.getX1() * operation.getX2();
            case "div" -> result = operation.getX1() / operation.getX2();
            default -> {
            }
        }
//        operation.setUser(user);
        operation.setResult(result);
        operation.setTime(LocalDateTime.now());
        return operationStorage.save(operation);
    }

    public List<Operation> getOperations() {
        return operationStorage.getElements();
    }

//    public List<Operation> getOperationsByUserId(User user) {
//        return getOperations().stream().filter(operation -> operation.getUser().getId() == user.getId()).toList();
//    }
    public Optional<Operation> findOperationById(String id){
        return operationStorage.findEntity(id);
    }
    public Operation delete(Operation operation){
        operationStorage.delete(operation);
        return operation;
    }
}
