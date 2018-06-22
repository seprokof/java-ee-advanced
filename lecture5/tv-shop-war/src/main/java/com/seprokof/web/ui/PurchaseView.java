package com.seprokof.web.ui;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.seprokof.anotation.Loggable;
import com.seprokof.dao.OrderDao;
import com.seprokof.dao.ProductDao;
import com.seprokof.dto.DeliveryAddress;
import com.seprokof.dto.Order;
import com.seprokof.dto.Order.OrderStatus;
import com.seprokof.dto.OrderRow;
import com.seprokof.dto.Product;

/**
 * Controller for the purchasing wizard.
 * 
 * @author seprokof
 *
 */
@Named
@ViewScoped
@Loggable
public class PurchaseView implements Serializable {
    private static final long serialVersionUID = 1157116234674910281L;

    @Inject
    private ProductDao productService;

    @Inject
    private OrderDao orderService;
    private LoginView client;

    private List<Product> availableProducts;
    private Product selectedProduct;
    private Map<Product, Integer> ordered;
    private DeliveryAddress address;

    @PostConstruct
    public void init() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        client = ctx.getApplication().evaluateExpressionGet(ctx, "#{loginView}", LoginView.class);
        availableProducts = productService.getAllProducts();
        ordered = new HashMap<>();
        address = new DeliveryAddress();
    }

    /**
     * Adds product to cart.
     * 
     * @param product
     *            to add
     */
    public void addToCart(Product product) {
        int count = ordered.get(product) == null ? 0 : ordered.get(product);
        ordered.put(product, count + 1);
    }

    /**
     * Stores order in the system.
     * 
     * @return redirects to orders view
     */
    public String save() {
        FacesContext ctx = FacesContext.getCurrentInstance();

        if (ordered.isEmpty()) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "The order can't be processed, because the cart is empty. Go and buy something", null));
            return null;
        }

        Order order = new Order();
        order.setClient(client.getLoggedClient());
        order.setCreationTime(new Date());
        order.setDeliveryAddress(address);
        order.setOrderLines(ordered.entrySet().stream().map(PurchaseView::createOrderRow).collect(Collectors.toList()));
        order.setStatus(OrderStatus.PREPARING);

        orderService.createOrder(order);
        return "orders?faces-redirect=true";
    }

    private static OrderRow createOrderRow(Entry<Product, Integer> entry) {
        OrderRow line = new OrderRow();
        line.setProduct(entry.getKey());
        line.setQuantity(entry.getValue());
        return line;
    }

    public List<Product> getAvailableProducts() {
        return availableProducts;
    }

    public void setAvailableProducts(List<Product> availableProducts) {
        this.availableProducts = availableProducts;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public DeliveryAddress getAddress() {
        return address;
    }

    public void setAddress(DeliveryAddress address) {
        this.address = address;
    }

    public Map<Product, Integer> getOrdered() {
        return ordered;
    }

}
