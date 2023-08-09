package com.example.crudBoot.dao;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.crudBoot.model.User;

import java.util.List;

@Repository
public class userDaoImpl implements userDao {


    private final EntityManager em;

    @Autowired
    public userDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<User> allUsers() {
        String query = "SELECT u FROM User u";
        return em.createQuery(query, User.class).getResultList();
    }

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public void delete(User user) {
        em.remove(em.contains(user) ? user : em.merge(user));

    }

    @Override
    public void edit(User user) {
        em.merge(user);

    }

    @Override
    public User getById(int id) {
        return em.find(User.class, id);
    }

}
