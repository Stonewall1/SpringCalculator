package by.tms.service;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.dao.InMemoryStorage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class CalculatorService {

    private final InMemoryStorage<Operation, Long> operationStorage;

    public CalculatorService(@Qualifier("HibernateOperationDao") InMemoryStorage<Operation, Long> operationStorage) {
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
        save(operation);
        return operation;
    }
    public Operation save(Operation operation){
        operationStorage.save(operation);
        return operation;
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
