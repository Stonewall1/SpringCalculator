package by.tms.service;

import by.tms.entity.User;
import by.tms.dao.Storage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    private final Storage<User, Long> userStorage;

    /**
     * why @Qualifier in constructor?
     */
    public UserService(@Qualifier("HibernateUserDao") Storage<User, Long> userStorage) {
        this.userStorage = userStorage;
    }

    @Transactional
    public void save(User user) {
        userStorage.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return userStorage.findById(id);
    }

    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return userStorage.getElements();
    }

    @Transactional(readOnly = true)
    public Optional<User> findUserByEmail(String email) {
        return userStorage.findEntity(email);
    }

    @Transactional
    public User updateUser(Long id , String name , String password) {
         return userStorage.updateEntity(id , name ,password);
    }

    @Transactional
    public User delete(User user) {
        userStorage.delete(user);
        return user;
    }
}
