package by.tms.storage;

import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
@Component
public class UserStorage implements InMemoryStorage<User>{

    private final List<User> users = new ArrayList<>();
    private static final AtomicLong idGenerator = new AtomicLong(0);
    @Override
    public User save(User user) {
        user.setId(idGenerator.incrementAndGet());
        users.add(user);
        return user;
    }

    public Optional<User> findByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }
    @Override
    public List<User> getElements() {
        return users;
    }
}
