package com.seprokof.dao;

import com.seprokof.dto.ShopClient;

public interface ShopClientsDao {

    ShopClient addShopClient(ShopClient user);

    ShopClient getShopClientById(Long id);

    ShopClient getShopClientByLogin(String login);

}
