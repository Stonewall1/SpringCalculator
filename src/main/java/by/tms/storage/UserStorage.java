package by.tms.storage;

import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
@Component
public class UserStorage implements InMemoryStorage<User>{
    private static UserStorage instance;

    private UserStorage() {

    }

    public static UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    private final List<User> users = new ArrayList<>();
    private static final AtomicLong idGenerator = new AtomicLong(0);
    @Override
    public User save(User user) {
        user.setId(idGenerator.incrementAndGet());
        users.add(user);
        return user;
    }

    public Optional<User> findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
    @Override
    public List<User> getElements() {
        return users;
    }
}
