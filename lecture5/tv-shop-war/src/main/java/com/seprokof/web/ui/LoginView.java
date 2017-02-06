package com.seprokof.web.ui;

import java.io.Serializable;

import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.seprokof.anotation.Loggable;
import com.seprokof.dao.ShopClientsDao;
import com.seprokof.dto.ShopClient;

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
    private ShopClientsDao shopClientService;

    private String login;
    private String password;
    private boolean isAuthenticated;

    /**
     * Authenticates user in the application.
     * 
     * @return user will be redirected to the orders page if login succeeded
     */
    public String authenticate() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            ShopClient loaded = shopClientService.getShopClientByLogin(login);
            if (loaded.getPassword().equals(password)) {
                isAuthenticated = true;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
