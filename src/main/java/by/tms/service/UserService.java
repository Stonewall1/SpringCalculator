package by.tms.service;

import by.tms.entity.User;
import by.tms.storage.InMemoryStorage;
import by.tms.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Qualifier("UserStorage")
    private final InMemoryStorage<User, Long> userStorage;

    @Autowired
    public UserService(UserStorage registeredUsersStorage) {
        this.userStorage = registeredUsersStorage;
    }

    public void register(User user) {
        userStorage.save(user);
    }

    public Optional<User> findById(Long id) {
        return userStorage.findById(id);
    }

    public List<User> getUsers() {
        return userStorage.getElements();
    }
    public Optional<User> findUserByEmail(String email){
        return userStorage.findEntity(email);
    }
}
