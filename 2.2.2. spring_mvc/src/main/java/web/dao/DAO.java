package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface DAO {

    public List<User> allPeople();

    public User personById(int id);

    public void save(User user);

    public void update(int id, User user);

    public void delete(int id);

}
