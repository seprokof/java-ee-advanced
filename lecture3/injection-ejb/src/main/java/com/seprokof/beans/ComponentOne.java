package com.seprokof.beans;

import javax.ejb.Stateless;

import com.seprokof.InterfaceOne;
import com.seprokof.InterfaceTwo;

@Stateless
public class ComponentOne implements InterfaceOne, InterfaceTwo {

    @Override
    public String getSmile() {
        return ComponentOne.class.getSimpleName() + " saw how " + InterfaceTwo.super.getSmile();
    }

    @Override
    public String getJoke() {
        return ComponentOne.class.getSimpleName() + " listen how " + InterfaceOne.super.getJoke();
    }

}
