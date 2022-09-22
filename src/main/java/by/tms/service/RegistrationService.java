package by.tms.service;

import by.tms.entity.User;
import by.tms.storage.UserStorage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class RegistrationService {
    private static RegistrationService instance;

    private RegistrationService() {

    }

    public static RegistrationService getInstance() {
        if (instance == null) {
            instance = new RegistrationService();
        }
        return instance;
    }

    private final UserStorage registeredUsersStorage = UserStorage.getInstance();

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
