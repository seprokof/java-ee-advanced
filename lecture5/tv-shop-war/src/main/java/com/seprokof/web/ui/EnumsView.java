package com.seprokof.web.ui;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.seprokof.dto.Order.OrderStatus;

/**
 * Utility bean used to correctly display various enum members.
 * 
 * @author seprokof
 *
 */
@Named
@ApplicationScoped
public class EnumsView {

    public OrderStatus[] getOrderStatus() {
        return OrderStatus.values();
    }

}
