package by.tms.service;

import by.tms.entity.User;
import by.tms.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    private UserStorage userStorage;

    @Autowired
    public UserService(UserStorage registeredUsersStorage) {
        this.userStorage = registeredUsersStorage;
    }

    public void register(User user) {
        userStorage.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userStorage.findByEmail(email);
    }

    public List<User> getUsers() {
        return userStorage.getElements();
    }
}
