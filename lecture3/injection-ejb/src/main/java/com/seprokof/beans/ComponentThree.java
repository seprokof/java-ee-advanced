package com.seprokof.beans;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Named;

import com.seprokof.InterfaceOne;
import com.seprokof.InterfaceTwo;

/**
 * Demonstrates the injection options.
 * 
 * @author seprokof
 *
 */
@Stateless
@Named
public class ComponentThree {

    @EJB(beanName = "ComponentOne")
    private InterfaceTwo injectedOne;

    @EJB(lookup = "java:module/ComponentTwo")
    private ComponentTwo injectedTwo;

    @Resource
    private SessionContext context;
    private InterfaceOne injectedThree;

    @EJB
    private TimezoneEjb injectedFour;

    @PostConstruct
    public void init() {
        injectedThree = (InterfaceOne) context.lookup(
                "java:global/packaging-ear-1.0.0-SNAPSHOT/injection-ejb-1.0.0-SNAPSHOT/ComponentOne!com.seprokof.InterfaceOne");
    }

    public String callOne() {
        return injectedOne.getSmile();
    }

    public String callTwo() {
        return injectedTwo.getSmile();
    }

    public String callThree() {
        return injectedTwo.rollDice();
    }

    public String callFour() {
        return injectedThree.getJoke();
    }

    public String callFive() {
        return "Timezone form the environment properties: " + injectedFour.getTimezone();
    }
}
