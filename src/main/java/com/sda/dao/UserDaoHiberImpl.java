package com.sda.dao;

import com.sda.model.Role;
import com.sda.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Repository
public class UserDaoHiberImpl implements UserDao {
    @PersistenceContext
    private EntityManager session;

    @Override
    public User getByLoginAndPassword(String login, String password) {
        TypedQuery<User> query = session.createQuery("Select x FROM User x Where x.login=:e and x.password=:p", User.class);
        query.setParameter("e", login);
        query.setParameter("p", password);
        System.out.println(query.getSingleResult());
        return query.getSingleResult();
    }

    @Override
    public User getByLogin(String login) {
        TypedQuery<User> query = session.createQuery("Select x FROM User x Where x.login=:e ", User.class);
        query.setParameter("e", login);
        User user =query.getSingleResult();
        return user;
    }
}
