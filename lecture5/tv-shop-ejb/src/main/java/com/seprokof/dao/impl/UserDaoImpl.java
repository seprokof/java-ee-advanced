package com.seprokof.dao.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.seprokof.dao.UserDao;
import com.seprokof.dto.User;

@Stateless
public class UserDaoImpl implements UserDao {

    @Inject
    private EntityManager em;

    @Override
    public User addUser(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        return em.createNamedQuery(User.GET_BY_LOGIN, User.class).setParameter(1, login).getSingleResult();
    }

}
