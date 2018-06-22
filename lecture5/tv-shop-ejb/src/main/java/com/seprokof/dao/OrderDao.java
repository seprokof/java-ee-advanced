package com.seprokof.dao;

import com.seprokof.dto.Order;

/**
 * The service is used to manage orders data.
 * 
 * @author seprokof
 *
 */
public interface OrderDao {

    /**
     * Persists new order instance in the database.
     * 
     * @param order
     *            the instance to persist
     * @return stored order
     */
    Order createOrder(Order order);

}
