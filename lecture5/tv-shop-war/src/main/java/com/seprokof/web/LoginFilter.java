package com.seprokof.web;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seprokof.anotation.Loggable;
import com.seprokof.web.ui.LoginView;

/**
 * Used to auto-login user with long-life cookies.
 * 
 * @author seprokof
 *
 */
public class LoginFilter implements Filter {

    @Inject
    private LoginView loginView;

    @Loggable
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        // prevent infinite loop
        // prevent issue with requesting resources
        if (request.getRequestURI().contains("/login.jsf") || request.getRequestURI().contains("/registration.jsf")
                || request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)) {
            chain.doFilter(req, res);
            return;
        }

        HttpSession session = ((HttpServletRequest) req).getSession(false);
        if (session == null || !loginView.isAuthenticated()) {
            // user is not logged in, redirect to login page
            response.sendRedirect(request.getContextPath() + "/login.jsf");
        } else {
            // session is fine, so just continue request
            chain.doFilter(req, res);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // do nothing
    }

    @Override
    public void destroy() {
        // do nothing
    }

}
