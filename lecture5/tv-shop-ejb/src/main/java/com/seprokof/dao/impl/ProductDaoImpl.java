package com.seprokof.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.seprokof.dao.ProductDao;
import com.seprokof.dto.Product;

@Stateless
public class ProductDaoImpl implements ProductDao {

    @Inject
    private EntityManager em;

    @Override
    public List<Product> getAllProducts() {
        return em.createNamedQuery(Product.GET_ALL, Product.class).getResultList();
    }

}
