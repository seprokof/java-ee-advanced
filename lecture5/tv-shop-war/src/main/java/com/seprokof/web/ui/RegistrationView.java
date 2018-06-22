package com.seprokof.web.ui;

import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.seprokof.anotation.Loggable;
import com.seprokof.dao.UserDao;
import com.seprokof.dto.User;

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
    private UserDao userDao;

    private User user = new User();

    /**
     * Registers new user in the system.
     * 
     * @return
     */
    public String register() {
        try {
            userDao.addUser(user);
        } catch (EJBException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "User already exisit, choose another login", null));
            return null;
        }
        return "login?faces-redirect=true";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
