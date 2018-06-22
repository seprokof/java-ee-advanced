package com.seprokof.web.ui;

import java.io.Serializable;

import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.seprokof.anotation.Loggable;
import com.seprokof.dao.UserDao;
import com.seprokof.dto.User;

/**
 * Controller for the login page. Remember me feature is used, the username will be stored in cookies, so that allows
 * user to skip prompt in rejoin.
 * 
 * @author seprokof
 *
 */
@Loggable
@Named
@SessionScoped
public class LoginView implements Serializable {
    private static final long serialVersionUID = -3826282210130414626L;

    @Inject
    private UserDao shopClientService;

    private User loggedClient = new User();
    private boolean isAuthenticated;

    /**
     * Authenticates user in the application.
     * 
     * @return user will be redirected to the orders page if login succeeded
     */
    public String authenticate() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            User loaded = shopClientService.getUserByLogin(loggedClient.getLogin());
            if (loaded.getPassword().equals(loggedClient.getPassword())) {
                isAuthenticated = true;
                loggedClient = loaded;
                return "orders?faces-redirect=true";
            } else {
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password is incorrect", null));
                return null;
            }
        } catch (EJBException e) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User doesn't exist", null));
            return null;
        }
    }

    /**
     * Logout user session.
     * 
     * @return redirect to the login page if succeeded
     */
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public User getLoggedClient() {
        return loggedClient;
    }

    public void setLoggedClient(User loggedClient) {
        this.loggedClient = loggedClient;
    }

}
