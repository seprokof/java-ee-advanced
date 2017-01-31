package com.seprokof.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.seprokof.InterfaceThree;
import com.seprokof.InterfaceTwo;

@Stateless
@LocalBean 
public class ComponentTwo implements InterfaceTwo, InterfaceThree {

    @Override
    public String rollDice() {
        return ComponentTwo.class.getSimpleName() + " rooting while " + InterfaceThree.super.rollDice();
    }

    @Override
    public String getSmile() {
        return ComponentTwo.class.getSimpleName() + " saw when " + InterfaceTwo.super.getSmile();
    }

}
