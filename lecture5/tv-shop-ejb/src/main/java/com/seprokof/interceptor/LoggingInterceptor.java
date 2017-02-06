package com.seprokof.interceptor;

import java.util.logging.Logger;

import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.seprokof.anotation.Loggable;

/**
 * Interceptor provides logging facility.
 * 
 * @author seprokof
 *
 */
@Interceptor
@Loggable
public class LoggingInterceptor {

    @AroundConstruct
    private void logConstructorInvoke(InvocationContext ic) throws Exception {
        Logger LOGGER = Logger.getLogger(ic.getTarget().getClass().getName());
        LOGGER.fine("Constructing " + ic.getTarget().getClass().getName() + " instance");
        try {
            ic.proceed();
            LOGGER.fine(ic.getTarget().getClass().getName() + " instance created sucessfully");
        } catch (Exception e) {
            LOGGER.severe(
                    "Error during instantiating the " + ic.getTarget().getClass().getName() + ": " + e.getMessage());
            throw e;
        }
    }

    @AroundInvoke
    private Object logMethodInvoke(InvocationContext ic) throws Exception {
        Logger LOGGER = Logger.getLogger(ic.getTarget().getClass().getName());
        LOGGER.entering(ic.getTarget().getClass().getName(), ic.getMethod().getName());
        Exception ex = null;
        try {
            return ic.proceed();
        } catch (Exception e) {
            ex = e;
            throw e;
        } finally {
            if (ex != null) {
                LOGGER.severe(ic.getTarget().getClass().getName() + "." + ic.getMethod().getName()
                        + " existed with exception: " + ex.getMessage());
            } else {
                LOGGER.exiting(ic.getTarget().getClass().getName(), ic.getMethod().getName());
            }
        }
    }

}
