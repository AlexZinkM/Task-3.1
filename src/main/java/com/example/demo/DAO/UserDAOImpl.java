package com.example.demo.DAO;


import com.example.demo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }


    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    @Transactional
    public User get(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public User delete(long id) throws NullPointerException {
        User user = get(id);
        if (null == user) {
            throw new NullPointerException("Нет такого пользователя");
        }
        entityManager.remove(user);
        entityManager.flush();
        return user;
    }

    @Override
    @Transactional
    public void create(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }






}
