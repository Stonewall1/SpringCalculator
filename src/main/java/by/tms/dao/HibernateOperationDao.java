package by.tms.dao;

import by.tms.entity.Operation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Component("HibernateOperationDao")
public class HibernateOperationDao implements InMemoryStorage<Operation, Long> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Operation save(Operation operation) {
        System.out.println(operation);
        Session session = sessionFactory.getCurrentSession();
        session.save(operation);
        return operation;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Operation> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Operation operation = session.find(Operation.class, id);
        return Optional.of(operation);
    }

    @Override
    @Transactional
    public Operation delete(Operation operation) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(operation);
        return operation;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Operation> getElements() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Operation", Operation.class).getResultList();
    }

    @Override
    public Optional<Operation> findEntity(String parameter) {
        return Optional.empty();
    }
}
