package com.seprokof.web.ui;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.seprokof.anotation.Loggable;
import com.seprokof.dto.Order;

/**
 * Controller for the orders dashboard view.
 * 
 * @author seprokof
 *
 */
@Named
@ViewScoped
@Loggable
public class OrdersView implements Serializable {
    private static final long serialVersionUID = -4287419604726534051L;

    private List<Order> orders;
    private Order selectedOrder;

    @PostConstruct
    public void init() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        LoginView loginView = ctx.getApplication().evaluateExpressionGet(ctx, "#{loginView}", LoginView.class);
        orders = loginView.getLoggedClient().getOrders();
    }

    public void delete() {
        orders.removeIf(o -> o.getId().equals(selectedOrder.getId()));
        selectedOrder = null;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Order getSelectedOrder() {
        return selectedOrder;
    }

    public void setSelectedOrder(Order selectedOrder) {
        this.selectedOrder = selectedOrder;
    }

}
