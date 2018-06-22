package com.seprokof.dao;

import java.util.List;

import com.seprokof.dto.Product;

/**
 * The service is used to manage products.
 * 
 * @author seprokof
 *
 */
public interface ProductDao {

    /**
     * Retrieves list of available products.
     * 
     * @return available products or empty collection
     */
    List<Product> getAllProducts();

}
