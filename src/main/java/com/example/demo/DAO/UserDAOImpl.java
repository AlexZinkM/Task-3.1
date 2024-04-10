package com.example.demo.DAO;


import com.example.demo.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDAOImpl extends JpaRepository<User, Long> {
}
//    @PersistenceContext
//    private EntityManager entityManager;
//
//
//    @Transactional
//    public List<User> getAll() {
//        return entityManager.createQuery("from User", User.class).getResultList();
//    }
//
//
//
//    @Transactional
//    public void update(User user) {
//        entityManager.merge(user);
//        entityManager.flush();
//    }
//
//
//    @Transactional
//    public User get(long id) {
//        return entityManager.find(User.class, id);
//    }
//
//
//    @Transactional
//    public User delete(long id) throws NullPointerException {
//        User user = get(id);
//        if (null == user) {
//            throw new NullPointerException("Нет такого пользователя");
//        }
//        entityManager.remove(user);
//        entityManager.flush();
//        return user;
//    }
//
//    @Transactional
//    public void create(User user) {
//        entityManager.persist(user);
//        entityManager.flush();
//    }
//
//
//
//
//
//
//}
