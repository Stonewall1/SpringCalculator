package by.tms.dao;

import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component("UserStorage")
public class UserStorage implements InMemoryStorage<User, Long> {

    private final List<User> users = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public User save(User user) {
        user.setId(idGenerator.incrementAndGet());
        users.add(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }

    @Override
    public User delete(User entity) {
        users.remove(entity);
        return entity;
    }

    @Override
    public List<User> getElements() {
        return users;
    }

    @Override
    public Optional<User> findEntity(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
