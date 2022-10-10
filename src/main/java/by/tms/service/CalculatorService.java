package by.tms.service;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.dao.Storage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class CalculatorService {

    private final Storage<Operation, Long> operationStorage;

    /**
     * why @Qualifier in constructor?
     */

    public CalculatorService(@Qualifier("HibernateOperationDao") Storage<Operation, Long> operationStorage) {
        this.operationStorage = operationStorage;
    }

    @Transactional
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

    @Transactional
    public Operation save(Operation operation) {
        operationStorage.save(operation);
        return operation;
    }

    @Transactional(readOnly = true)
    public List<Operation> getOperations() {
        return operationStorage.getElements();
    }

    //    public List<Operation> getOperationsByUserId(User user) {
//        return getOperations().stream().filter(operation -> operation.getUser().getId() == user.getId()).toList();
//    }
    @Transactional(readOnly = true)
    public Optional<Operation> findOperationById(String id) {
        return operationStorage.findEntity(id);
    }

    @Transactional
    public Operation delete(Operation operation) {
        operationStorage.delete(operation);
        return operation;
    }
}
