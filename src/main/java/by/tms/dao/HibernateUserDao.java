package by.tms.dao;

import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component("HibernateUserDao")
public class HibernateUserDao implements Storage<User, Long> {

    private final SessionFactory sessionFactory;

    public HibernateUserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.find(User.class, id);
        return Optional.of(user);
    }

    @Override
    public User delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
        return user;
    }

    @Override
    public List<User> getElements() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User ", User.class).getResultList();
    }

    @Override
    public Optional<User> findEntity(String email) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.createQuery("from User where email =:x", User.class).setParameter("x", email).getSingleResult();
        return Optional.of(user);
    }

    @Override
    public User updateEntity(Long id, String param1, String param2) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update User set name = :nameP , password =:passwordP where id =:ip")
                .setParameter("ip", id)
                .setParameter("nameP", param1)
                .setParameter("passwordP", param2)
                .executeUpdate();
        return session.createQuery("from User where id =:x", User.class).setParameter("x", id).getSingleResult();
    }
}
