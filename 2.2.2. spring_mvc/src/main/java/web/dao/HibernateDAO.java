package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HibernateDAO implements DAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> allPeople() {
        return entityManager.createQuery("SELECT a FROM User a", User.class).getResultList();
    }

    @Override
    @Transactional
    public User personById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        User userToUpdate = personById(id);
        userToUpdate = entityManager.merge(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(personById(id));
    }
}
