package by.tms.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class Operation {
    private long id;
    @NotNull(message = "Field cant be empty")
    private Double x1;
    @NotNull(message = "Field cant be empty")
    private Double x2;
    private Double result;
    @NotBlank(message = "Field cant be empty")
    private String operation;

    private User user;

    private LocalDateTime time;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Operation() {

    }

    public Operation(Double x1, double x2, String operation) {
        this.x1 = x1;
        this.x2 = x2;
        this.operation = operation;
    }

    public Operation(Double x1, double x2, String operation, LocalDateTime time) {
        this.x1 = x1;
        this.x2 = x2;
        this.operation = operation;
        this.time = time;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Double getX1() {
        return x1;
    }

    public void setX1(Double x1) {
        this.x1 = x1;
    }

    public Double getX2() {
        return x2;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Operation{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", result=" + result +
                ", operation='" + operation + '\'' +
                ", time=" + time +
                '}';
    }
}
