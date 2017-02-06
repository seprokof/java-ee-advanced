package com.seprokof.dao.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.seprokof.dao.ShopClientsDao;
import com.seprokof.dto.ShopClient;

@Stateless
public class UserDaoImpl implements ShopClientsDao {

    @Inject
    private EntityManager em;

    @Override
    public ShopClient addShopClient(ShopClient user) {
        em.persist(user);
        return user;
    }

    @Override
    public ShopClient getShopClientById(Long id) {
        return em.find(ShopClient.class, id);
    }

    @Override
    public ShopClient getShopClientByLogin(String login) {
        return em.createNamedQuery(ShopClient.GET_BY_LOGIN, ShopClient.class).setParameter(1, login).getSingleResult();
    }

}
