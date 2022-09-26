package by.tms.service;

import by.tms.entity.User;
import by.tms.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    private UserStorage registeredUsersStorage;

    @Autowired
    public UserService(UserStorage registeredUsersStorage) {
        this.registeredUsersStorage = registeredUsersStorage;
    }

    public void register(User user) {
        registeredUsersStorage.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return registeredUsersStorage.findByEmail(email);
    }

    public List<User> getUsers() {
        return registeredUsersStorage.getElements();
    }
}
