package com.seprokof.dao.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.seprokof.dao.OrderDao;
import com.seprokof.dto.Order;
import com.seprokof.dto.User;

@Stateless
public class OrderDaoImpl implements OrderDao {

    @Inject
    private EntityManager em;

    @Override
    public Order createOrder(Order order) {
        em.persist(order);
        User client = order.getClient();
        client.getOrders().add(order);
        em.merge(client);
        return order;
    }

}
