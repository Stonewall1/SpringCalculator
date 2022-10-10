package by.tms.dao;

import by.tms.entity.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Component("HibernateOperationDao")
public class HibernateOperationDao implements Storage<Operation, Long> {

    private final SessionFactory sessionFactory;

    public HibernateOperationDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Operation save(Operation operation) {
        Session session = sessionFactory.getCurrentSession();
        session.save(operation);
        return operation;
    }

    @Override
    public Optional<Operation> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Operation operation = session.find(Operation.class, id);
        return Optional.of(operation);
    }

    @Override
    public Operation delete(Operation operation) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(operation);
        return operation;
    }

    @Override
    public List<Operation> getElements() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Operation", Operation.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Operation> findEntity(String parameter) {
        return Optional.empty();
    }

    @Override
    public Operation updateEntity(Long aLong, String param1, String param2) {
        return null;
    }

}
