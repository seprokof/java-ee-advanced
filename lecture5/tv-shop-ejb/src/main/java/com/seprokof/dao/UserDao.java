package com.seprokof.dao;

import javax.persistence.NoResultException;

import com.seprokof.dto.User;

/**
 * The service is used to manage shop client.
 * 
 * @author seprokof
 *
 */
public interface UserDao {

    /**
     * Persists new client in the database.
     * 
     * @param user
     *            the instance to persist
     * @return stored user
     */
    User addUser(User user);

    /**
     * Retrieves client by login.
     * 
     * @param login
     *            the login of client
     * @return user with specified login
     * @throws NoResultException
     *             will be thrown if no user found with such login
     */
    User getUserByLogin(String login);

}
