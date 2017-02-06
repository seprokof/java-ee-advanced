package com.seprokof.web.ui;

import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.seprokof.anotation.Loggable;
import com.seprokof.dao.ShopClientsDao;
import com.seprokof.dto.ShopClient;

/**
 * Registration process controller.
 * 
 * @author seprokof
 *
 */
@Named("regView")
@RequestScoped
@Loggable
public class RegistrationView {

    @Inject
    private ShopClientsDao userDao;

    private ShopClient user = new ShopClient();

    /**
     * Registers new user in the system.
     * 
     * @return
     */
    public String register() {
        try {
            userDao.addShopClient(user);
        } catch (EJBException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "User already exisit, choose another login", null));
            return null;
        }
        return "login?faces-redirect=true";
    }

    public ShopClient getUser() {
        return user;
    }

    public void setUser(ShopClient user) {
        this.user = user;
    }

}
