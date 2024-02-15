package spring.boot.pp_3_1_1.dao;

import org.springframework.stereotype.Repository;
import spring.boot.pp_3_1_1.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public User getUser(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void deleteById(Long id) {
        em.remove(getUser(id));
    }


}
